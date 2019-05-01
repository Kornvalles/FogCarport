package FunctionLayer;

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

        double postsOnWidth = Math.max(((double) carport.getWidth() / 100) - 1, 0);
        int roundedWidth = (int) Math.ceil(postsOnWidth);

        return ((auto + getPostsOnLongside(carport)) * 2) + roundedWidth;
    }

    /**
     * This method returns the number of posts on 1 side of the input carport.
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
     * This method returns the number of wooden boards needed to make the roof
     * of the input carport. For each post on 1 side there has to be on wooden
     * board across the roof.
     */
    public static int getRoof(Carport carport) {
        /* This if statement runs if the carport has a pointy roof*/
        if (carport.hasPointyRoof()) {
            return 0;
        } else {
            return calcRectangle(carport.getLength(), carport.getWidth());
        }
    }

    /**
     * This method returns the number of wooden boards needed to make 1
     * rectangle of wood. input1 is always the direction of the wooden board. --
     * At the roof input1 is the length and input2 is the width -- At the two
     * sides input1 is the length and input2 is the height -- At the backside
     * input1 is the width and input2 is the height
     */
    public static int calcRectangle(int input1, int input2) {
        int totalBoards;

        /* Defining the size of a wooden board, get numbers from database */
        int woodLength = 100;
        int woodWidth = 10;

        /* How many wooden boards can fit in the length? */
        int boardsInLength = input1 / woodLength;

        /* How many wooden boards can fit in the width? */
        int boardsInWidth = input2 / woodWidth;

        int rest = input1 % woodLength;

        /* The number of wooden boards on a flat roof using as little wood 
            as possible */
        if (rest == 0) {
            totalBoards = boardsInWidth * boardsInLength;
        } else {
            /* Making sure that you get a whole wood board even though you 
                might only need a fraction of it */
            double reuseBoards = (double) (rest * boardsInWidth) / woodLength;
            int rounded = (int) Math.ceil(reuseBoards);

            totalBoards = boardsInWidth * boardsInLength + rounded;
        }
        return totalBoards;
    }

    /**
     * This method returns the number of wooden boards needed to make all sides
     * of the input carport.
     */
    public static int getSides(Carport carport) {
        int longsides = 2 * (calcRectangle(carport.getLength(), carport.getHeight()));
        int backside = calcRectangle(carport.getWidth(), carport.getHeight());

        return longsides + backside;
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
        int screwsOnRoof = getRoof(carport) * 6;

        /* The getBattens-method returns the number of meters in wooden battens
        and not the number of battens. To get the number of screws we calculate 
        the number of post on longside. We need 3 screws for each post for both 
        the side battens and the roof battens in all 6 screws for each post*/
        int screwsOnBattens = 2 * getPostsOnLongside(carport) * 6;

        return screwsOnSides + screwsOnRoof + screwsOnBattens;
    }

    /**
     * This method returns a list of all material needed for the input carport.
     */
    public static List<Material> getAllMaterial(Carport carport) throws FogException {
        List material = new ArrayList<>();

        /* Get name and price from sql database */
        Material post = new Material("post", getAllPosts(carport),"pcs", LogicFacade.getMaterialPrice("post"));
        Material wood = new Material("wood board 10x100cm", getSides(carport) + getRoof(carport),"pcs", LogicFacade.getMaterialPrice("wood board 10x100cm"));
        Material roofBatten = new Material("roof battens", getRoofBattens(carport)/100,"m", LogicFacade.getMaterialPrice("roof battens"));
        Material sideBatten = new Material("side battens", getSideBattens(carport)/100,"m", LogicFacade.getMaterialPrice("side battens"));
        Material screw = new Material("screw", getScrews(carport),"pcs", LogicFacade.getMaterialPrice("screw"));
        
        material.add(post);
        material.add(wood);
        material.add(roofBatten);
        material.add(sideBatten);
        material.add(screw);
        
        return material;
    }

    /**
     * This method returns the total price of the input carport. Material prices
     * are in the database.
     */
    public static double getTotalPrice(Carport carport) throws FogException {
        List<Material> materials = getAllMaterial(carport);
        
        double totalPrice = 0;
        double totalItemPrice;
        
        for (int i = 0; i < materials.size(); i++) {
            totalItemPrice = materials.get(i).getPrice() * materials.get(i).getQty();
            totalPrice += totalItemPrice;
        }
         
        return Double.parseDouble(String.format("%.2f",totalPrice));
    }

}
