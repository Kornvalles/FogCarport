package FunctionLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iben
 */
public class Calculator {

    /**
     * This method returns the number of posts needed to make the input carport.
     * Calculates for 1 longside, multiplies in the end and adds backside.
     */
    public static int getAllPosts(Carport carport) {
        /* One side of the carport automatically has 1 post at each end */
        int auto = 2;

        return ((auto + getPostsOnLongside(carport)) * 2) + getPostsOnBackside(carport);
    }

    /**
     * This method returns the number of posts on 1 longside of the input
     * carport.
     */
    public static int getPostsOnLongside(Carport carport) {
        /* Dividing by 100 gives the number of spaces, by substracting 1 you get
        the number of splitters/poles between the poles in the ends.
        Math.max makes sure that posts cannot be negative. */
        double postsOnLength = Math.max(((double) carport.getLength() / 100) - 1, 0);

        /* Making sure that you get a pole for each beginning meter */
        return (int) Math.ceil(postsOnLength);
    }

    /**
     * This method returns the number of posts on 1 backside of the input
     * carport.
     */
    public static int getPostsOnBackside(Carport carport) {
        /* Dividing by 100 gives the number of spaces, by substracting 1 you get
        the number of splitters/poles between the poles in the ends.
        Math.max makes sure that posts cannot be negative. */
        double postsOnWidth = Math.max(((double) carport.getWidth() / 100) - 1, 0);

        /* Making sure that you get a pole for each beginning meter */
        return (int) Math.ceil(postsOnWidth);
    }

    /**
     * This method returns the number of wooden boards needed to make the roof
     * of the input carport. For each post on 1 side there has to be on wooden
     * board across the roof.
     */
    public static int getRoof(Carport carport) {
        
        /* This if statement runs if the carport has a pointy roof*/
        int pvcSheetLength = 10;
        int pvcSheetWidth = 10;

        if (!carport.hasPointyRoof()) {
            
            return calcMaterial(carport.getLength(), carport.getWidth(), pvcSheetLength, pvcSheetWidth);
        } else {
            double vinkelC = 90; // statisk fordi denne vinkel altid er 90 grader.
            double vinkelA = carport.getRoofAngle();
            double vinkelB = vinkelC - vinkelA;
            
            double vinkelA_inRadians = Math.toRadians(vinkelA);
            double vinkelB_inRadians = Math.toRadians(vinkelB);

            double a = carport.getWidth() / 2;
            double b = ((a *Math.sin(vinkelB_inRadians)) / (Math.sin(vinkelA_inRadians)));
            double c = Math.sqrt(Math.pow(a, 2.00) + Math.pow(b, 2.00)) - 2.00 * a * b * Math.cos(vinkelC);
            
            int pvcSheetL = pvcSheetLength;
            int pvcSheetW = pvcSheetWidth;
            
            return calcMaterial(carport.getLength(), (int) c ,pvcSheetW, pvcSheetL);
            
        }
    }

    /**
     * This method returns the number of wooden boards needed to make 1
     * rectangle of wood. input1 is always the direction of the wooden board. --
     * At the roof input1 is the length and input2 is the width -- At the two
     * sides input1 is the length and input2 is the height -- At the backside
     * input1 is the width and input2 is the height
     */
    public static int calcMaterial(int input1, int input2, int materialLength, int materialWidth) {
        int totalMaterial;


        /* How many wooden boards can fit in the length? */
        int materialInLength = input1 / materialLength;

        /* How many wooden boards can fit in the width? */
        int materialInWidth = input2 / materialWidth;

        int rest = input1 % materialLength;

        /* The number of wooden boards on a flat roof using as little wood 
            as possible */
        if (rest == 0) {
            totalMaterial = materialInWidth * materialInLength;
        } else {
            /* Making sure that you get a whole wood board even though you 
                might only need a fraction of it */
            int reuseBoards = (rest * materialInWidth) / materialLength;
            int rounded = (int) Math.ceil(reuseBoards);

            totalMaterial = materialInWidth * materialInLength + rounded;
        }
        return totalMaterial;
    }

    /**
     * This method returns the number of wooden boards needed to make all sides
     * of the input carport.
     */
    public static int getSides(Carport carport) {

        int woodLength = 100;
        int woodWidth = 10;
        int longsides = 2 * (calcMaterial(carport.getLength(), carport.getHeight(), woodLength, woodWidth));
        int backside = calcMaterial(carport.getWidth(), carport.getHeight(), woodLength, woodWidth);

        return longsides + backside;
    }

    /**
     * This method returns...
     */
    public static int makeShed(Carport carport) {

        return 0;
    }

    /**
     * This method returns the number of centimeters in wooden battens needed
     * across the roof. We put the battens where the posts is on the longside of
     * the carport.
     */
    public static int getRoofBattens(Carport carport) {
        return getPostsOnLongside(carport) * carport.getWidth();
    }

    /**
     * This method returns the number of centimeters in wooden battens needed
     * along the 2 sides of the roof.
     */
    public static int getSideBattens(Carport carport) {
        return 2 * carport.getLength();
    }

    /**
     * This method returns the number of screws needed for 1 wooden board.
     */
    public static int getScrews(Carport carport) {
        int screwsOnSides = getSides(carport) * 6;

        /* The getBattens-method returns the number of meters in wooden battens
        and not the number of battens. To get the number of screws we calculate 
        the number of post on longside. We need 3 screws for each post for both 
        the side battens and the roof battens in all 6 screws for each post*/
        int screwsOnBattens = 2 * getPostsOnLongside(carport) * 6;

        return screwsOnSides + screwsOnBattens;
    }

    /**
     * This method returns a list of all material needed for the input carport.
     */
    public static Construction constructCarport(Carport carport, LogicFacade logic) throws FogException, SQLException {
        List<Material> material = new ArrayList<>();

        /* Get name and price from sql database */
        Material post = new Material("stolpe(r)", getAllPosts(carport), "pcs", logic.getMaterialPrice("stolpe(r)"));
        Material wood = new Material("planke(r) 10x100cm", getSides(carport), "pcs", logic.getMaterialPrice("planke(r) 10x100cm"));
        Material roofBatten = new Material("taglaegte(r)", getRoofBattens(carport) / 100, "m", logic.getMaterialPrice("taglaegte(r)"));
        Material sideBatten = new Material("sidelaegte(r)", getSideBattens(carport) / 100, "m", logic.getMaterialPrice("sidelaegte(r)"));
        Material screw = new Material("skruer 200 stk", getScrews(carport)/200, "pakker", logic.getMaterialPrice("skruer 200 stk"));
        Material roofTile = new Material("tagsten", getRoof(carport), "pcs", logic.getMaterialPrice("tagsten"));
        Material pvcRoofSheet = new Material("tagplade(r)", getRoof(carport), "pcs", logic.getMaterialPrice("tagplade(r)"));

        material.add(post);
        material.add(wood);
        material.add(roofBatten);
        material.add(sideBatten);
        material.add(screw);
        material.add(pvcRoofSheet);

        double totalPrice = 0;
        double totalItemPrice;

        for (int i = 0; i < material.size(); i++) {
            totalItemPrice = material.get(i).getPrice() * material.get(i).getQty();
            totalPrice += totalItemPrice;
        }

        return new Construction(carport, material, totalPrice);
    }
}
