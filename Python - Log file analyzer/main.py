import re

result_logs_file = open('result.log', 'w')
pattern = r'.*(01\/Jul\/1995:03:)(3[5-9]|4[0-9]|5[0-4]).*( [3-5][0-9][0-9] ).*\n'
unique_addresses = {}


for line in open('raw.log', 'r', encoding='windows-1251').readlines():
    match = re.compile(pattern).match(line)
    if match:
        address = re.search(r'[0-9a-zA-Z.\-]+ - ', line).group(0)
        if address in unique_addresses:
            unique_addresses[address] = {
                'counter': unique_addresses[address]['counter'] + 1,
                'log': line
            }
        else:
            unique_addresses[address] = {
                'counter': 1,
                'log': line
            }


unique_addresses = sorted(unique_addresses.items(), key=lambda x: x[1]['counter'])

for key, value in unique_addresses:
    if value['counter'] == 1:
        result_logs_file.write(value['log'])
    else:
        break
