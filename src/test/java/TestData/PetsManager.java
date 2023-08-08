package TestData;

import POJO.Request.Pets;
import POJO.Request.PetCategory;
import POJO.Request.PetTags;

import java.util.ArrayList;
import java.util.logging.Logger;

public class PetsManager extends Pets {

    private static Logger logger = Logger.getLogger(PetsManager.class.getName());
    public static ArrayList<Pets> createPets()
    {
        ArrayList<Pets> listDogs = new ArrayList<>();

        Pets petDog1 = new Pets();
        Pets petDog2 = new Pets();
        Pets petDog3 = new Pets();

        PetCategory category1 = new PetCategory();
        PetCategory category2 = new PetCategory();
        PetCategory category3 = new PetCategory();

        ArrayList<PetTags> tags1 = new ArrayList<PetTags>();
        ArrayList<PetTags> tags2 = new ArrayList<PetTags>();
        ArrayList<PetTags> tags3 = new ArrayList<PetTags>();

        PetTags petTags1 = new PetTags();
        PetTags petTags2 = new PetTags();
        PetTags petTags3 = new PetTags();

        ArrayList<String> urls1 = new ArrayList<String>();
        ArrayList<String> urls2 = new ArrayList<String>();
        ArrayList<String> urls3 = new ArrayList<String>();

        logger.info("Creating 1st Dog attributes");

        petDog1.setId(1111);
        petDog1.setName("dog001");
        petDog1.setStatus("available");
        category1.setId(1111);
        category1.setName("BullDog");
        petTags1.setName("dog1Tag");
        petTags1.setId(1111);
        tags1.add(petTags1);
        petDog1.setCategory(category1);
        petDog1.setTags(tags1);
        urls1.add("google");
        petDog1.setPhotoUrls(urls1);

        logger.info("Creating 2nd Dog attributes");

        petDog2.setId(2222);
        petDog2.setName("dog002");
        petDog2.setStatus("pending");
        category2.setId(2222);
        category2.setName("GermanShepherd");
        petTags2.setName("dog2Tag");
        petTags2.setId(2222);
        tags2.add(petTags2);
        petDog2.setCategory(category2);
        petDog2.setTags(tags2);
        urls2.add("facebook");
        petDog2.setPhotoUrls(urls2);

        logger.info("Creating 3rd Dog attributes");

        petDog3.setId(3333);
        petDog3.setName("dog003");
        petDog3.setStatus("sold");
        category3.setId(3333);
        category3.setName("Labrador");
        petTags3.setName("dog3Tag");
        petTags3.setId(3333);
        tags3.add(petTags3);
        petDog3.setCategory(category3);
        petDog3.setTags(tags3);
        urls3.add("twitter");
        petDog3.setPhotoUrls(urls3);

        listDogs.add(petDog1);
        listDogs.add(petDog2);
        listDogs.add(petDog3);

        return listDogs;
    }
}
