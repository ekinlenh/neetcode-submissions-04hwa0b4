class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        # example 1: 1 -> 4 -> 7 -> 10, 4 -> 6 -> 8 -> 10
        # the first problem we need to solve is getting the intersection point between car 1 and car 2
        # let car 1 be: y = 3x + 1 where y = position and x = time (with 3 being the speed factor)
        # let car 2 be: y = 2x + 4
        # 3x + 1 = 2x + 4 -> x = 3 -> plug into equation -> y = 3(3) + 1 = 10
        # we check if 10 >= target and in this case it is, hence there is only 1 car fleet (only 2 cars)
        # let's try another example
        # example 2: 4 -> 6 -> 8 -> 10, 1 -> 3 -> 5 -> 7 -> 9 -> 11, 7 -> 8 -> 9 -> 10
        # car 1: y = 2x + 4, car 2: y = 2x + 1, car 3: y = x + 7
        # 2x + 4 = 2x + 1 -> no solutions, means they won't intersect and therefore separate fleets
        # 2x + 4 = x + 7 -> x = 3 -> cars 1 and 2 do meet, which means they become one fleet
        # second problem: how can i easily check for these intersections/no solutions to determine # of fleets?
        # notice: we don't need to check intersections, what if we compare time it takes to reach the end?
        # in example 2: cars 1 and 3 take a time of 3 which means they intersect, but car 2 takes (10-1)/2=4.5
        # so we should first calculate the time it takes for each car to reach the target
        # so any car behind that takes a smaller time to reach the end will catch up to the front car
        # and they become part of the same fleet
        # third problem: how can we check for fleets when the times are dispersed in the array?
        # solution: we can sort by times, which we can then use to know when a new fleet is created or not
        # so we want to keep track of both a car's position and time and then we sort and check for fleets
        # note: we want to sort from closest -> furthest b/c a car behind can catch up to the car in front

        n = len(position)
        res = []
        for i in range(n):
            time = (target - position[i]) / speed[i]
            car = [position[i], time]
            res.append(car)
        
        res.sort(reverse=True)
        fleets = 0
        fleet_time = 0 # time of the fleet ahead
        for i in range(n):
            curr_time = res[i][1]
            if curr_time > fleet_time: # if current car takes longer than the fleet ahead, it cannot catch up
                fleets += 1 # so it becomes a new fleet
                fleet_time = curr_time # and we check all the others behind the fleet with this fleet's time

        return fleets