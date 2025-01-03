class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        res = []
        parts = [''] * 4
        end = len(s) - 1
        def helper(start, part):
            if start >= len(s):
                return
            if part == 3:
                if start == end or (s[start] != '0' and int(s[start:end + 1]) <= 255):
                    parts[part] = s[start:]
                    res.append('.'.join(parts))
            else:
                for pause in range(start, start + 3):
                    if start == pause or (s[start] != '0' and int(s[start:pause + 1]) <= 255):
                        parts[part] = s[start:pause + 1]
                        helper(pause + 1, part + 1)
        helper(0, 0)
        return res