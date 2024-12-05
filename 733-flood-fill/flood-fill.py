class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        original = image[sr][sc]
        if color == original: return image
        def fill(sr, sc):
            if image[sr][sc] == original:
                image[sr][sc] = color
                if sr - 1 >= 0:
                    fill(sr - 1, sc)
                if sr + 1 < len(image):
                    fill(sr + 1, sc)
                if sc - 1 >= 0:
                    fill(sr, sc - 1)
                if sc + 1 < len(image[0]):
                    fill(sr, sc + 1)
        fill(sr, sc)
        return image
        
        