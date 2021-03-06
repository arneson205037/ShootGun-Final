package com.shootGame.main; 
  
public class SpecialAlgorithms { 
   public SpecialAlgorithms() {} 
    
  public static int[] arcRotation(int givenX, int givenY, int xOfRotation, int yOfRotation, int rotAngle) { 
     int[] returnValues = new int[3]; 
      
    int newX = (int)(xOfRotation + ((xOfRotation - givenX) * Math.cos(Math.toRadians(rotAngle)) - (yOfRotation - givenY) * Math.sin(Math.toRadians(rotAngle)))); 
     int newY = (int)(yOfRotation + ((yOfRotation - givenY) * Math.cos(Math.toRadians(rotAngle)) + (xOfRotation - givenX) * Math.sin(Math.toRadians(rotAngle)))); 
      
    returnValues[0] = newX; 
     returnValues[1] = newY; 
     returnValues[2] = rotAngle; 
      
    return returnValues; 
   } 
    
 
  public static double[] headingToProjectedXY(int x, int y, double radius, double heading) 
   { 
     double[] returnArray = new double[2]; 
     double angle = heading % 90.0D; 
      
    double projectedX = (int)(radius * Math.sin(Math.toRadians(angle)) * 1000.0D) / 1000.0D; 
     double projectedY = (int)(radius * Math.cos(Math.toRadians(angle)) * 1000.0D) / 1000.0D; 
      
    if (heading >= 270.0D) 
     { 
       projectedX = (int)(radius * Math.cos(Math.toRadians(angle)) * 1000.0D) / 1000.0D; 
       projectedY = (int)(radius * Math.sin(Math.toRadians(angle)) * 1000.0D) / 1000.0D; 
       returnArray[0] = (x + projectedX); 
       returnArray[1] = (y + projectedY); 
     } 
     else if (heading >= 180.0D) 
     { 
       projectedX = (int)(radius * Math.sin(Math.toRadians(angle)) * 1000.0D) / 1000.0D; 
       projectedY = (int)(radius * Math.cos(Math.toRadians(angle)) * 1000.0D) / 1000.0D; 
       returnArray[0] = (x + projectedX); 
       returnArray[1] = (y - projectedY); 
     } 
     else if (heading >= 90.0D) 
     { 
       projectedX = (int)(radius * Math.cos(Math.toRadians(angle)) * 1000.0D) / 1000.0D; 
       projectedY = (int)(radius * Math.sin(Math.toRadians(angle)) * 1000.0D) / 1000.0D; 
       returnArray[0] = (x - projectedX); 
       returnArray[1] = (y - projectedY); 
     } 
     else if (heading >= 0.0D) 
     { 
       projectedX = (int)(radius * Math.sin(Math.toRadians(angle)) * 1000.0D) / 1000.0D; 
       projectedY = (int)(radius * Math.cos(Math.toRadians(angle)) * 1000.0D) / 1000.0D; 
       returnArray[0] = (x - projectedX); 
       returnArray[1] = (y + projectedY); 
     } 
      
    return returnArray; 
   } 
    
  public static double[] headingToProjectedXY(double heading) 
   { 
     double[] returnArray = new double[2]; 
     double angle = heading % 90.0D; 
      
    double projectedX = (int)(Math.sin(Math.toRadians(angle)) * 1000.0D) / 1000.0D; 
     double projectedY = (int)(Math.cos(Math.toRadians(angle)) * 1000.0D) / 1000.0D; 
      
    if (heading > 270.0D) 
     { 
       returnArray[0] = (-1.0D * projectedX); 
       returnArray[1] = projectedY; 
       return returnArray; 
     } 
     if (heading > 180.0D) 
     { 
       returnArray[0] = (-1.0D * projectedX); 
       returnArray[1] = (-1.0D * projectedY); 
       return returnArray; 
     } 
     if (heading > 90.0D) 
     { 
       returnArray[0] = projectedX; 
       returnArray[1] = (-1.0D * projectedY); 
       return returnArray; 
     } 
     if (heading >= 0.0D) 
     { 
       returnArray[0] = projectedX; 
       returnArray[1] = projectedY; 
       return returnArray; 
     } 
      
    return returnArray; 
   } 
    
  public static double circlify(double val) 
   { 
     double temp = val; 
     if (temp < 0.0D) 
     { 
       while (temp < 0.0D) 
         temp = val + 360.0D; 
       return temp; 
     } 
      
    if (temp < 360.0D) 
     { 
       return temp; 
     } 
      
    if (temp == 360.0D) 
     { 
       return 0.0D; 
     } 
      
    if (temp > 360.0D) 
     { 
       while (temp > 360.0D) 
         temp -= 360.0D; 
       return temp; 
     } 
      
 
    return temp; 
   } 
    
  public static double roundToThousandths(double val) 
   { 
     return (int)(val * 1000.0D) / 1000.0D; 
   } 
    
  public static double medianDegrees(double valA, double valB) 
   { 
     double mean = valB; 
     double delta = -1.0D; 
     double higher = 0.0D; 
     double lower = 0.0D; 
      
    if (valA > valB) 
     { 
       delta = valA - valB; 
       higher = valA; 
       lower = valB; 
     } 
     else if (valA < valB) 
     { 
       delta = valB - valA; 
       higher = valB; 
       lower = valA; 
     } 
     else if (valA == valB) 
     { 
       return roundToThousandths(mean); 
     } 
      
 
    if (delta > 180.0D) 
     { 
       mean = circlify((higher + lower) / 2.0D - 180.0D); 
     } else { 
       if (delta == 180.0D) 
       { 
         return 404.0D; 
       } 
       if (delta < 180.0D) 
       { 
         mean = circlify((higher + lower) / 2.0D); 
       } 
     } 
      
    return roundToThousandths(mean); 
   } 
} 
  