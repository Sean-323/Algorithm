def expand_ipv6(address):
    parts = address.split(':')
    expanded_parts = []

    for part in parts:
        if part:
            expanded_parts.append(part.zfill(4))
        else:
            expanded_parts.append(part)

    return ':'.join(expanded_parts)

def normalize_ipv6(address):
    if '::' in address:
        left, right = address.split('::')
        left_parts = left.split(':') if left else []
        right_parts = right.split(':') if right else []
        omit = 8 - (len(left_parts) + len(right_parts))
        expanded_address = ':'.join(left_parts + ['0'] * omit + right_parts)
    else:
        expanded_address = address

    return expand_ipv6(expanded_address)

address = input().strip()
print(normalize_ipv6(address))