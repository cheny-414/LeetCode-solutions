class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        products.sort()
        result = []

        for i in range(1, len(searchWord) + 1):
            prefix = searchWord[:i]

            idx = bisect_left(products, prefix)
            suggestions = []

            for j in range(idx, min(idx + 3, len(products))):
                if products[j].startswith(prefix):
                    suggestions.append(products[j])
            result.append(suggestions)
        return result