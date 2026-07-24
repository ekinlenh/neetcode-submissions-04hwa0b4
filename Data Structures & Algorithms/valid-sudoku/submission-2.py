class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # brute force:
        # three different parts: rows, columns, 3x3 grids
        # we can check these all separately, while using a set to ensure no dupes
        board_length = len(board[0])

        # ROWS
        for row in range(board_length):
            row_set = set()
            for col in range(board_length):
                if board[row][col] == ".":
                    continue
                if board[row][col] not in row_set:
                    row_set.add(board[row][col])
                else:
                    return False
        
        # COLS
        for col in range(board_length):
            col_set = set()
            for row in range(board_length):
                if board[row][col] == ".":
                    continue
                if board[row][col] not in col_set:
                    col_set.add(board[row][col])
                else:
                    return False
        
        # 3x3 GRIDS
        for row in range(0, board_length, 3):
            for col in range(0, board_length, 3):
                grid_set= set()
                for r in range(3):
                    for c in range(3):
                        cell = board[row + r][col + c]
                        if cell == ".":
                            continue
                        if cell not in grid_set:
                            grid_set.add(cell)
                        else:
                            return False

        return True
        