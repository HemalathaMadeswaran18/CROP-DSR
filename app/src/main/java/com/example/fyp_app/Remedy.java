package com.example.fyp_app;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;


@Entity
public class Remedy {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "CROPNAME")
    public String CropName;

    @ColumnInfo(name = "DISEASE")
    public String Disease;

    @ColumnInfo(name = "CAUSE")
    public String Cause;

    @ColumnInfo(name = "INDICATOR")
    public String Indicator;

    @ColumnInfo(name = "Remedy")
    public String Remedy;



    public Remedy() {
        // Empty constructor
    }

    public Remedy(int uid, String cropName, String disease, String cause, String indicator, String remedy) {
        this.uid = uid;
        CropName = cropName;
        Disease = disease;
        Cause = cause;
        Indicator = indicator;
        Remedy = remedy;
    }

    @Override
    public String toString() {
        return "Remedy{" +
                "uid=" + uid +
                ", CropName='" + CropName + '\'' +
                ", Disease='" + Disease + '\'' +
                ", Cause='" + Cause + '\'' +
                ", Indicator='" + Indicator + '\'' +
                ", Remedy='" + Remedy + '\'' +
                '}';
    }

    public String getRemedy() {
        return Remedy;
    }

    public void setRemedy(String remedy) {
        Remedy = remedy;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCropName() {
        return CropName;
    }

    public void setCropName(String cropName) {
        CropName = cropName;
    }

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String disease) {
        Disease = disease;
    }

    public String getCause() {
        return Cause;
    }

    public void setCause(String cause) {
        Cause = cause;
    }

    public String getIndicator() {
        return Indicator;
    }

    public void setIndicator(String indicator) {
        Indicator = indicator;
    }







    public static Remedy[] populateData() {
        return new Remedy[] {
                new Remedy(0, "Apple", "Apple Scab", "fungus Venturia inaequalis", " On the lower side of the leaf lesion appear as olivaceous spots which turn dark brown to black and become velvety.", "Adhere to general preventive measures, such as clearing and disposing of fallen leaves and fruit. Keep a close eye on early spring leaf and flower emergence of previously affected trees and apply preventive sprays to break the infection cycle."),

                new Remedy(1, "Apple", "Black Rot", " Diplodia seriata (syn Botryosphaeria obtusa)","Infected leaves develop frog-eye leaf spot. These are circular spots with reddish edges and light tan interiors.", "To control the disease, it is important to prune out any dead or diseased branches and remove any dried or shriveled fruits from the trees. It is also important to remove any infected plant material from the area, which should either be burned, buried or sent to a municipal composting site. Additionally, make sure to remove the stumps of any apple trees that have been cut down as dead stumps can be a source of spores."),

                new Remedy(2, "Apple", "Cedar Apple Rust", "Gymnosporangium juniperi-virginianae", "This disease first appears on apple leaves as small greenish yellow spots. The spots gradually enlarge and change colour to orange-yellow.", "Apple trees can generally tolerate leaf spots and fruit infections caused by cedar apple rust, as long as they do not result in significant leaf loss. Therefore, it is not necessary to use fungicides to prevent the infection of apple trees with cedar apple rust, as the trees and shrubs can often withstand the infection."),

                new Remedy(3," Apple","Healthy","-","-","-"),

                new Remedy(4, "Blackgram", "Anthracnose", "C. lindemuthianum", " Symptoms are circular, black, sunken spots with dark center and bright red orange margins on leaves and pods."," It is important to remove and dispose of any plant debris, and spray either Mancozeb at a rate of 2g/liter or Carbendazim at a rate of 0.5g/liter to prevent infection."),

                new Remedy(5," Blackgram","Healthy ","-","-","-"),

                new Remedy(6, "Blackgram", "Leaf Crinkle", "Urdbean leaf crinkle virus (ULCV)", " The earliest symptoms appear on youngest leaves as chlorosis around some lateral veins and its branches near the margin. The leaves show curling of margin downwards. Some of the leaves show twisting. The veins show reddish brown discolouration on the under surface which also extends to the petiole."," Infected plants should be removed up to 45 days, and a foliar spray of either notchi leaf extract at 10% at 30 days after sowing or neem formulation at a rate of 3 ml per liter should be applied."),

                new Remedy(7, "Blackgram", "Powdery Mildew", "Erysiphe polygoni", "White powdery patches appear on leaves and other green parts which later become dull coloured. These patches gradually increase in size and become circular covering the lower surface also. When the infection is severe, both the surfaces of the leaves are completely covered by whitish powdery growth. Severely affected parts get shriveled and distorted. In severe infections, foliage becomes yellow causing premature defoliation. The disease also creates forced maturity of the infected plants which results in heavy yield losses."," To control the disease, it is recommended to spray NSKE at a rate of 5% or Neem oil at a rate of 3% twice, at 10-day intervals from the initial appearance of the disease. It is also suggested to spray Eucalyptus leaf extract at a rate of 10% at the onset of the disease and again 10 days later."),

                new Remedy(8, "Blackgram", "Yellow Mosaic", "Mungbean Yellow Mosaic Virus", "Initially mild scattered yellow spots appear on young leaves. The next trifoliate leaves emerging from the growing apex show irregular yellow and green patches alternating with each other. Spots gradually increase in size and ultimately some leaves turn completely yellow."," Infected plants should be removed up to 45 days, and a foliar spray of either notchi leaf extract at 10% at 30 days after sowing or neem formulation at a rate of 3 ml per liter should be applied. If necessary, spray Methyl demeton 25 EC at a rate of 500 ml per hectare, or Dimethoate 30 EC at a rate of 500 ml per hectare, or Thiamethoxam 75 WS at a rate of 1g per 3 liters and repeat after 15 days."),

                new Remedy(9, "Grape", "Black Rot", "Guignardia bidwellii", "Reddish brown and circular to angular spots appear on the upper surface of the leaves starting in late spring. As spots merge, they form irregular, reddish brown blotches. The center of the leaf spot turns tannish brown and is surrounded by a black margin."," During the dormant pruning period, remove all dried-up fruits from the vines. When the buds begin to sprout, cultivate the soil to bury the dried-up fruits and decrease the source of infection."),

                new Remedy(10, "Grape", "Esca (Black Measles)", "Phaeoacremonium aleophilum and Phaeomoniella chlamydospora", "The 'stripes', which start out as dark red in red cultivars and yellow in white cultivars, dry and become necrotic."," Currently, there is no proven method to effectively manage this disease. The recommended approach is to eliminate the affected berries, leaves, and trunk by disposing of them properly."),

                new Remedy(11,"Grape ","Healthy","-","-","-"),

                new Remedy(12, "Grape", "Leaf Blight (Isariopsis Leaf Spot)", "Pseudocercospora vitis", "On leaf surface we will see lesions which are irregularly shaped (2 to 25 mm in diameter). Initially lesions are dull red to brown in color turn black later."," Fungicides sprayed for other diseases in the season may help to reduce this disease."),

                new Remedy(13,"Potato","Early Blight","Alternaria solani.","Brown-black necrotic spot-angular, oval shape characterized by concentric rings. Several spot coalesce & spread all over the leaf."," To prevent the spread of infection, it is important to remove and dispose of any infected plant debris since the spores in the soil are the main source of infection. For effective control, spraying with Zineb or Captan at 0.2% should be carried out very early and repeated every 15 to 20 days."),

                new Remedy(14,"Potato "," Healthy ","-","-","-"),

                new Remedy(15,"Potato","Late Blight","Phytophthora infestans","Water soaked spots appear on leaves, increase in size, turn purple brown & finally black color. White growth develops on the under surface of leaves."," To prevent tuber infection, it is advisable to carry out protective spraying with mancozeb or zineb at 0.2%. Harvest injuries should be avoided and visibly infected tubers should not be stored to minimize tuber contamination."),

                new Remedy(16, "Tomato", "Bacterial Spot", "Xanthomonas axonopodis pv. vesicatoria", "Small, brown, water-soaked, circular spots with a yellow halo on leaves."," For chemical control of the disease, Streptomycin sulphate 90% + Tetracycline hydrochloride 10% SP can be used both in the seed bed and in the field."),

                new Remedy(17, "Tomato", "Early Blight", "Alternaria solani", "Brown spots with concentric rings in a bull's eye pattern with yellow margin."," To control the spread of disease, it is recommended to remove and destroy crop debris and practice crop rotation. Additionally, spraying with either Hexaconazole 5% SC at a rate of 1ml per liter, or Propiconazole 25% EC at a rate of 500 ml per hectare, at 30 and 50 days after planting, or Metiram 70% WG at a rate of 2.5kg per hectare may be effective."),

                new Remedy(18," Tomato"," Healthy ","-","-","-"),

                new Remedy(19, "Tomato", "Late Blight", "Phytophthora infestans", "Water-soaked black lesions on leaves and stems. Lesions expand rapidly and the entire leaf becomes necrotic. White sporulation (sporangia and sporangiophores) on leaves."," One of the following fungicides may be applied: Azoxystrobin 23% SC at a rate of 500 ml per hectare, Cyazofamid 34.5% SC at a rate of 200 ml per hectare, Mancozeb 35% SC at a rate of 2.5 liters per hectare, Zineb 75% WP at a rate of 1 kg per hectare, or Azoxystrobin 18.2% + Difenoconazole 11.4% w/w SC at a rate of 500 ml per hectare."),

                new Remedy(20, "Tomato", "Septoria Leaf Spot", "Septoria lycopersici", "Small, round to irregular spots with grey centre and dark margin on leaves. Spots coalesce and leaves are blighted."," To control the disease, it is recommended to remove and destroy affected plant parts. One option for chemical control is to apply Fluxapyroxad 250 g/l + Pyraclostrobin 250 g/l SC at a rate of 200-250 ml per hectare. ")


        };
    }

    public static Remedy getRemedyById(int uid) {
        // Create an array of Remedy objects
        Remedy[] remedies = {
                new Remedy(0, "Apple", "Apple Scab", "fungus Venturia inaequalis", " On the lower side of the leaf lesion appear as olivaceous spots which turn dark brown to black and become velvety.", "Adhere to general preventive measures, such as clearing and disposing of fallen leaves and fruit. Keep a close eye on early spring leaf and flower emergence of previously affected trees and apply preventive sprays to break the infection cycle."),

                new Remedy(1, "Apple", "Black Rot", " Diplodia seriata (syn Botryosphaeria obtusa)","Infected leaves develop frog-eye leaf spot. These are circular spots with reddish edges and light tan interiors.", "To control the disease, it is important to prune out any dead or diseased branches and remove any dried or shriveled fruits from the trees. It is also important to remove any infected plant material from the area, which should either be burned, buried or sent to a municipal composting site. Additionally, make sure to remove the stumps of any apple trees that have been cut down as dead stumps can be a source of spores."),

                new Remedy(2, "Apple", "Cedar Apple Rust", "Gymnosporangium juniperi-virginianae", "This disease first appears on apple leaves as small greenish yellow spots. The spots gradually enlarge and change colour to orange-yellow.", "Apple trees can generally tolerate leaf spots and fruit infections caused by cedar apple rust, as long as they do not result in significant leaf loss. Therefore, it is not necessary to use fungicides to prevent the infection of apple trees with cedar apple rust, as the trees and shrubs can often withstand the infection."),

                new Remedy(3," Apple","Healthy","-","-","-"),

                new Remedy(4, "Blackgram", "Anthracnose", "C. lindemuthianum", " Symptoms are circular, black, sunken spots with dark center and bright red orange margins on leaves and pods."," It is important to remove and dispose of any plant debris, and spray either Mancozeb at a rate of 2g/liter or Carbendazim at a rate of 0.5g/liter to prevent infection."),

                new Remedy(5," Blackgram","Healthy ","-","-","-"),

                new Remedy(6, "Blackgram", "Leaf Crinkle", "Urdbean leaf crinkle virus (ULCV)", " The earliest symptoms appear on youngest leaves as chlorosis around some lateral veins and its branches near the margin. The leaves show curling of margin downwards. Some of the leaves show twisting. The veins show reddish brown discolouration on the under surface which also extends to the petiole."," Infected plants should be removed up to 45 days, and a foliar spray of either notchi leaf extract at 10% at 30 days after sowing or neem formulation at a rate of 3 ml per liter should be applied."),

                new Remedy(7, "Blackgram", "Powdery Mildew", "Erysiphe polygoni", "White powdery patches appear on leaves and other green parts which later become dull coloured. These patches gradually increase in size and become circular covering the lower surface also. When the infection is severe, both the surfaces of the leaves are completely covered by whitish powdery growth. Severely affected parts get shriveled and distorted. In severe infections, foliage becomes yellow causing premature defoliation. The disease also creates forced maturity of the infected plants which results in heavy yield losses."," To control the disease, it is recommended to spray NSKE at a rate of 5% or Neem oil at a rate of 3% twice, at 10-day intervals from the initial appearance of the disease. It is also suggested to spray Eucalyptus leaf extract at a rate of 10% at the onset of the disease and again 10 days later."),

                new Remedy(8, "Blackgram", "Yellow Mosaic", "Mungbean Yellow Mosaic Virus", "Initially mild scattered yellow spots appear on young leaves. The next trifoliate leaves emerging from the growing apex show irregular yellow and green patches alternating with each other. Spots gradually increase in size and ultimately some leaves turn completely yellow."," Infected plants should be removed up to 45 days, and a foliar spray of either notchi leaf extract at 10% at 30 days after sowing or neem formulation at a rate of 3 ml per liter should be applied. If necessary, spray Methyl demeton 25 EC at a rate of 500 ml per hectare, or Dimethoate 30 EC at a rate of 500 ml per hectare, or Thiamethoxam 75 WS at a rate of 1g per 3 liters and repeat after 15 days."),

                new Remedy(9, "Grape", "Black Rot", "Guignardia bidwellii", "Reddish brown and circular to angular spots appear on the upper surface of the leaves starting in late spring. As spots merge, they form irregular, reddish brown blotches. The center of the leaf spot turns tannish brown and is surrounded by a black margin."," During the dormant pruning period, remove all dried-up fruits from the vines. When the buds begin to sprout, cultivate the soil to bury the dried-up fruits and decrease the source of infection."),

                new Remedy(10, "Grape", "Esca (Black Measles)", "Phaeoacremonium aleophilum and Phaeomoniella chlamydospora", "The 'stripes', which start out as dark red in red cultivars and yellow in white cultivars, dry and become necrotic."," Currently, there is no proven method to effectively manage this disease. The recommended approach is to eliminate the affected berries, leaves, and trunk by disposing of them properly."),

                new Remedy(11,"Grape ","Healthy","-","-","-"),

                new Remedy(12, "Grape", "Leaf Blight (Isariopsis Leaf Spot)", "Pseudocercospora vitis", "On leaf surface we will see lesions which are irregularly shaped (2 to 25 mm in diameter). Initially lesions are dull red to brown in color turn black later."," Fungicides sprayed for other diseases in the season may help to reduce this disease."),

                new Remedy(13,"Potato","Early Blight","Alternaria solani.","Brown-black necrotic spot-angular, oval shape characterized by concentric rings. Several spot coalesce & spread all over the leaf."," To prevent the spread of infection, it is important to remove and dispose of any infected plant debris since the spores in the soil are the main source of infection. For effective control, spraying with Zineb or Captan at 0.2% should be carried out very early and repeated every 15 to 20 days."),

                new Remedy(14,"Potato "," Healthy ","-","-","-"),

                new Remedy(15,"Potato","Late Blight","Phytophthora infestans","Water soaked spots appear on leaves, increase in size, turn purple brown & finally black color. White growth develops on the under surface of leaves."," To prevent tuber infection, it is advisable to carry out protective spraying with mancozeb or zineb at 0.2%. Harvest injuries should be avoided and visibly infected tubers should not be stored to minimize tuber contamination."),

                new Remedy(16, "Tomato", "Bacterial Spot", "Xanthomonas axonopodis pv. vesicatoria", "Small, brown, water-soaked, circular spots with a yellow halo on leaves."," For chemical control of the disease, Streptomycin sulphate 90% + Tetracycline hydrochloride 10% SP can be used both in the seed bed and in the field."),

                new Remedy(17, "Tomato", "Early Blight", "Alternaria solani", "Brown spots with concentric rings in a bull's eye pattern with yellow margin."," To control the spread of disease, it is recommended to remove and destroy crop debris and practice crop rotation. Additionally, spraying with either Hexaconazole 5% SC at a rate of 1ml per liter, or Propiconazole 25% EC at a rate of 500 ml per hectare, at 30 and 50 days after planting, or Metiram 70% WG at a rate of 2.5kg per hectare may be effective."),

                new Remedy(18," Tomato"," Healthy ","-","-","-"),

                new Remedy(19, "Tomato", "Late Blight", "Phytophthora infestans", "Water-soaked black lesions on leaves and stems. Lesions expand rapidly and the entire leaf becomes necrotic. White sporulation (sporangia and sporangiophores) on leaves."," One of the following fungicides may be applied: Azoxystrobin 23% SC at a rate of 500 ml per hectare, Cyazofamid 34.5% SC at a rate of 200 ml per hectare, Mancozeb 35% SC at a rate of 2.5 liters per hectare, Zineb 75% WP at a rate of 1 kg per hectare, or Azoxystrobin 18.2% + Difenoconazole 11.4% w/w SC at a rate of 500 ml per hectare."),

                new Remedy(20, "Tomato", "Septoria Leaf Spot", "Septoria lycopersici", "Small, round to irregular spots with grey centre and dark margin on leaves. Spots coalesce and leaves are blighted."," To control the disease, it is recommended to remove and destroy affected plant parts. One option for chemical control is to apply Fluxapyroxad 250 g/l + Pyraclostrobin 250 g/l SC at a rate of 200-250 ml per hectare. ")
        };

        // Loop through the array and return the Remedy object with the matching uid
        for (Remedy remedy : remedies) {
            if (remedy.getUid() == uid) {
                //todo link to the number from crop name
                System.out.println(remedy.getCropName().toString());
                return remedy;
            }
        }

        // If no matching Remedy object is found, return null
        return null;
    }






}