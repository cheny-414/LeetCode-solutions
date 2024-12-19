class UnionFind:
    def __init__(self):
        self.parent = {}
        self.rank = {}
    def find(self, a):
        if a not in self.parent:
            self.parent[a] = a
            self.rank[a] = 0
        if self.parent[a] != a:
            self.parent[a] = self.find(self.parent[a])
        return self.parent[a]
    def union(self, a, b):
        parent_of_a = self.find(a)
        parent_of_b = self.find(b)
        if parent_of_a == parent_of_b:
            return False
        if self.rank[parent_of_a] < self.rank[parent_of_b]:
            self.parent[parent_of_a] = parent_of_b
        elif self.rank[parent_of_a] > self.rank[parent_of_b]:
            self.parent[parent_of_b] = parent_of_a
        else:
            self.parent[parent_of_b] = parent_of_a
            self.rank[parent_of_a] += 1
        return True
class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        emailToName = {}
        parentToChildren = defaultdict(list)
        uf = UnionFind()
        res = []
        for account in accounts:
            name = account[0]
            parent_email = account[1]
            emailToName[parent_email] = name
            uf.find(parent_email)
            for i in range(2, len(account)):
                email = account[i]
                emailToName[email] = name
                uf.union(parent_email, email)
        for email in emailToName:
            parent = uf.find(email)
            parentToChildren[parent].append(email)

        for parent in parentToChildren:
            account = []
            account.append(emailToName[parent])
            account.extend(sorted(parentToChildren[parent]))
            res.append(account)
        return res