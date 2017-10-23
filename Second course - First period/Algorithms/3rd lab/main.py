raw_input = open('sigkey.in', 'r').read().split('\n')[1:]
keys = []
pair_index = 0
template = 'abcdefghijklmnopqrstuvwxyz'

for item in sorted(raw_input):
    keys.append({
        'value': item
    })

for key in keys:
    for item in keys:
        if 'link' in key or 'link' in item:
            continue

        tmp_str = set(key['value'] + item['value'])
        size = len(tmp_str)

        if tmp_str == set(template[:size]):
            item['link'] = key['link'] = pair_index
            pair_index += 1

print(pair_index)
