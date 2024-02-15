class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int noOfGasStations = gas.length;
        for(int i = 0; i< gas.length  ; i++){
            if(gas[i] >= cost[i]){
                int amtOfGasInCar = 0;
                int gasSpent=0;
                int noOfStationsCovered = 0;
                int j = i;
                
                while( noOfStationsCovered < gas.length ){
                    amtOfGasInCar = (amtOfGasInCar - gasSpent) +gas[j % noOfGasStations];
                    if(amtOfGasInCar >= cost[j % noOfGasStations]){

                        noOfStationsCovered++;
                        gasSpent = cost[j % noOfGasStations];
                        j++;

                    }else{
                        break;
                    }
                }
                
                if(noOfStationsCovered == noOfGasStations) return i;
            }
            
        }

        return -1;
        
    }
}
