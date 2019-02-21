package edu.cs.niu.z1829024.weightcalculator;

/**
 * Created by Z1829024 on 2/5/2018.
 * Created by Harshith Desamsetti.
 * A Shipping cost calculator application.
 */

public class ShippingItem
    {
        //Constants
        static final Double BASE_AMOUNT = 3.00;
        static final Double ADDED_AMOUNT = 0.50;
        static final Double EXTRA_OUNCES = 4.0;

        static final java.lang.Integer BASE_WEIGHT = 16;

        //Instance Variables
        private Integer weight;
        private Double baseCost, addedCost, totalCost;



        //Constructor
        public ShippingItem()
        {
            weight = 0;
            baseCost = BASE_AMOUNT;
            addedCost = 0.0;
            totalCost = 0.0;
        }

        //GETTERS
        public Double getBaseCost() {
            return baseCost;
        }

        public Double getAddedCost() {
            return addedCost;
        }

        public Double getTotalCost() {
            return totalCost;
        }


        //SETTERS
        public void setWeight(Integer newWeight)
        {
            weight = newWeight;
            computeCosts();
        }

        //CompuetCosts()
        private void computeCosts()
        {
            //reset the added and base costs back to their initial values
            addedCost = 0.0;
            baseCost = BASE_AMOUNT;

            //update the base cost OR added cost based on the weight
            if(weight <= 0)
                baseCost = 0.0;
            else if(weight > BASE_WEIGHT)
                addedCost = Math.ceil((double)(weight - BASE_WEIGHT)/EXTRA_OUNCES)*ADDED_AMOUNT;

            //Calculate the total cost
            totalCost = baseCost+addedCost;
        }



    }//End of ShippingItem
