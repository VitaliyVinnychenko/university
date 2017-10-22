raw_input = open('sigkey.in', 'r').read().split('\n')[1:]

keys = []
pair_index = 0
sample = 'abcdefghijklmnopqrstuvwxyz'


for item in sorted(raw_input):
    keys.append({
        'value': item
    })

for key in keys:
    for item in keys:
        if 'link' in key or 'link' in item:
            continue

        tmp_str = ''.join(sorted(key['value'] + item['value']))
        size = len(tmp_str)

        if sample[:size] == tmp_str:
            item['link'] = key['link'] = pair_index
            pair_index += 1


result = open('sigkey.out', 'w')
result.write(str(pair_index))
result.close()
