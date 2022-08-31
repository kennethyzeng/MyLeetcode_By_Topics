###########
Time Complexity: O(n)
Space Complexity: O(1)


#############
class Solution:
	def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
		
		# base case
		if sum(gas) - sum(cost) < 0:
			return -1

		gas_tank = 0  # gas available in car till now
		start_index = 0  # Consider first gas station as starting point

		for i in range(len(gas)):

			gas_tank += gas[i] - cost[i]

			if gas_tank < 0:  # the car has deficit of petrol
				start_index = i+1  # change the starting point
				gas_tank = 0  # make the current gas to 0, as we will be starting again from next station

		return start_index