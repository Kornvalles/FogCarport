package FunctionLayer;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author mikkel
 */
public class Calculator {

    /**
     * This method returns the number of posts needed to make the input carport.
     * Calculates for 1 longside, multiplies in the end and adds backside.
     *
     * @param carport
     * @return
     */
    public static int getAllPosts(Carport carport) {
        /* One side of the carport automatically has 1 post at each end */
        int auto = 2;

        return ((auto + getPostsOnLongside(carport)) * 2) + getPostsOnBackside(carport);
    }

    /**
     * This method returns the number of posts on 1 longside of the input
     * carport.
     *
     * @param carport
     * @return
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
     *
     * @param carport
     * @return
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
     * This method returns the number of roof materials needed to make the roof
 of the input carport. For each post on 1 side there has to be on wooden
     * board across the roof.
     *
     * @param carport
     * @return
     */
    public static int getRoof(Carport carport) {

        int pvcSheet = 100;
        int roofTiles = 30;
        int pointyWithTiles;
        /**
         * This if statement checks if the carport has a pointy roof
         */
        if (!carport.hasPointyRoof()) {
            if (carport.roofType()) {
                return calcMaterial(carport.getLength(), carport.getWidth(), roofTiles, roofTiles);
            } else {
                return calcMaterial(carport.getLength(), carport.getWidth(), pvcSheet, pvcSheet);
            }
        } else {
            double vinkelC = 90; // statisk fordi denne vinkel altid er 90 grader.
            double vinkelA = carport.getRoofAngle();
            double vinkelB = vinkelC - vinkelA;

            double vinkelA_inRadians = Math.toRadians(vinkelA);
            double vinkelB_inRadians = Math.toRadians(vinkelB);
            double vinkelC_inRadians = Math.toRadians(vinkelC);
            /*
            *    So to calculate the side b we take the width of the carport and divide by 2.
            *    we then take the width b, and multiply that by the angle of A and divide it by the angle of B.
            *    we use radians because Java cant calculate actual degrees.
             */
            double b = carport.getWidth() / 2;
            double a = ((b * Math.sin(vinkelA_inRadians)) / (Math.sin(vinkelB_inRadians))); // tagets højde uden carport.
            double c = ((b * Math.sin(vinkelC_inRadians)) / (Math.sin(vinkelB_inRadians)));
            if (carport.roofType()) {
                return (int) Math.ceil(calcMaterial(carport.getLength(), (int) c, roofTiles, roofTiles) * 2);
            } else {
                pointyWithTiles = (int) Math.ceil(calcMaterial(carport.getLength(), (int) c, pvcSheet, pvcSheet) * 2);
            }
        }
        return pointyWithTiles;
    }

    /**
     * This method returns the number of materials needed to make 1 rectangle of
 materials. input1 is always the direction of the materials. -- On the roof
 input1 is the length and input2 is the width -- On the two sides input1
 is the length and input2 is the height -- At the backside input1 is the
 width and input2 is the height
     *
     * @param input1 // length
     * @param input2 // width
     * @param materialLength
     * @param materialWidth
     * @return
     */
    public static int calcMaterial(int input1, int input2, int materialLength, int materialWidth) {
        int totalMaterial;


        /* How many materials units can fit in the length? */
        int materialInLength = (int) Math.ceil(input1 / materialLength);

        /* How many materials units can fit in the width? */
        int materialInWidth = (int) Math.ceil(input2 / materialWidth);

        int rest = (int) Math.ceil(input1 % materialLength);

        /* The number of materials units on a flat surface using as little materials 
            as possible */
        if (rest == 0) {
            totalMaterial = materialInWidth * materialInLength;
        } else {
            /* Making sure that you get a whole materials unit even though you 
                might only need a fraction of it */
            int reuseBoards = (rest * materialInWidth) / materialLength;
            int rounded = (reuseBoards);

            totalMaterial = materialInWidth * materialInLength + rounded;
        }
        return totalMaterial;
    }

    /**
     * This method returns the number of wooden boards needed to make all sides
     * of the input carport.
     *
     * @param carport
     * @return
     */
    public static int getSides(Carport carport) {

        int woodLength = 100;
        int woodWidth = 10;
        int longsides = 2 * (calcMaterial(carport.getLength(), carport.getHeight(), woodLength, woodWidth));
        int backside = calcMaterial(carport.getWidth(), carport.getHeight(), woodLength, woodWidth);

        return longsides + backside;
    }

    /**
     * This method either returns all sides of a shed if the carport doesnt have
     * wall or the remaining of a shed if the carport do have walls, or returns
     * nothing if the carport is without one.
     *
     * @param carport
     * @return
     */
    public static int makeShed(Carport carport) {
        int woodLength = 100;
        int woodWidth = 10;
        /**
         * If the carport have walls the first part of the if-statement returns
         * the remaining sides to complete a fully functional shed.
         */
        if (carport.hasWall()) {

            int shedInnerLength = calcMaterial(carport.getWidth(), carport.getHeight(), woodLength, woodWidth);

            return shedInnerLength;
        } /**
         * If the carport doesnt have walls the second part of this if-statement
         * returns all four sides of a fully functional shed.
         */
        else {
            int shedWidth = 2 * calcMaterial(carport.getShedWidth(), carport.getHeight(), woodLength, woodWidth);
            int shedLength = 2 * calcMaterial(carport.getWidth(), carport.getHeight(), woodLength, woodWidth);

            return shedWidth + shedLength;
        }
    }

    /**
     * This method returns the number of centimeters in wooden battens needed
     * across the roof. We put the battens where the posts is on the longside of
     * the carport.
     *
     * @param carport
     * @return
     */
    public static int getRoofBattens(Carport carport) {
        return getPostsOnLongside(carport) * carport.getWidth();
    }

    /**
     * This method returns the number of centimeters in wooden battens needed
     * along the 2 sides of the roof.
     *
     * @param carport
     * @return
     */
    public static int getSideBattens(Carport carport) {
        return 2 * carport.getLength();
    }

    /**
     * This method returns the number of screws needed for 1 wooden board.
     *
     * @param carport
     * @return
     */
    public static int getScrews(Carport carport) {

        double totalScrewPacks = 0;
        double screwsOnSides = Math.ceil(getSides(carport) * 6);

        /* The getBattens-method returns the number of meters in wooden battens
        and not the number of battens. To get the number of screws we calculate 
        the number of post on longside. We need 3 screws for each post for both 
        the side battens and the roof battens in all 6 screws for each post*/
        double screwsOnBattens = Math.ceil(2 * getPostsOnLongside(carport) * 6);

        totalScrewPacks = ((screwsOnSides + screwsOnBattens) / 200);
        return (int) totalScrewPacks;
    }

    /**
     * This method returns a list of all materials needed for the input carport.
     *
     * @param carport
     * @param logic
     * @return
     * @throws FunctionLayer.FogException
     * @throws java.sql.SQLException
     */
    public static Construction constructCarport(Carport carport, LogicFacade logic) throws FogException, SQLException {
        List<Material> materials = new ArrayList<>();
        DecimalFormat dF = new DecimalFormat("#.##");
        
        /* Get name and price from sql database */
        Material post = new Material("stolpe(r)", logic.getMaterialId("stolpe(r)"), getAllPosts(carport), "stk", logic.getMaterialPrice("stolpe(r)"), logic.getMaterialCostPrice("stolpe(r)"), logic.getMaterialDescription("stolpe(r)"));
        Material wood = new Material("planke(r) 10x100cm", logic.getMaterialId("planke(r) 10x100cm"), getSides(carport), "stk", logic.getMaterialPrice("planke(r) 10x100cm"), logic.getMaterialCostPrice("planke(r) 10x100cm"), logic.getMaterialDescription("planke(r) 10x100cm"));
        Material shedWood = new Material("planke(r) 10x100cm (skur)", logic.getMaterialId("planke(r) 10x100cm"), makeShed(carport), "stk", logic.getMaterialPrice("planke(r) 10x100cm"), logic.getMaterialCostPrice("planke(r) 10x100cm"), logic.getMaterialDescription("planke(r) 10x100cm")); // virker ikke endnu.
        Material roofBatten = new Material("taglaegte(r)", logic.getMaterialId("taglaegte(r)"), getRoofBattens(carport) / 100, "m", logic.getMaterialPrice("taglaegte(r)"), logic.getMaterialCostPrice("taglaegte(r)"), logic.getMaterialDescription("taglaegte(r)"));
        Material sideBatten = new Material("sidelaegte(r)", logic.getMaterialId("sidelaegte(r)"), getSideBattens(carport) / 100, "m", logic.getMaterialPrice("sidelaegte(r)"), logic.getMaterialCostPrice("sidelaegte(r)"), logic.getMaterialDescription("sidelaegte(r)"));
        Material screw = new Material("skruer 200 stk", logic.getMaterialId("skruer 200 stk"), getScrews(carport), "pakker", logic.getMaterialPrice("skruer 200 stk"), logic.getMaterialCostPrice("skruer 200 stk"), logic.getMaterialDescription("skruer 200 stk"));
        Material roofTile = new Material("tagsten", logic.getMaterialId("tagsten"), getRoof(carport), "stk", logic.getMaterialPrice("tagsten"), logic.getMaterialCostPrice("tagsten"), logic.getMaterialDescription("tagsten"));
        Material pvcRoofSheet = new Material("tagplade(r)", logic.getMaterialId("tagplade(r)"), getRoof(carport), "stk", logic.getMaterialPrice("tagplade(r)"), logic.getMaterialCostPrice("tagplade(r)"), logic.getMaterialDescription("tagplade(r)"));

        materials.add(post);
        if (carport.hasWall()) {
            materials.add(wood);
        }
        materials.add(roofBatten);
        materials.add(sideBatten);
        materials.add(screw);
        if (carport.roofType()) {
            materials.add(roofTile);
        } else {
            materials.add(pvcRoofSheet);
        }
        if (carport.hasToolshed()) {
            materials.add(shedWood);
        }

        double totalPrice = 0;
        double totalItemPrice;

        for (int i = 0; i < materials.size(); i++) {
            totalItemPrice = materials.get(i).getPrice() * materials.get(i).getQty();
            totalPrice += totalItemPrice;
        }
        
        return new Construction(carport, materials, totalPrice);
    }
}
