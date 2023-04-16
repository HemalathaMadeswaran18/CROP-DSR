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


    @ColumnInfo(name = "lowInfection")
    public String lowInfection;

    @ColumnInfo(name = "moderateInfection")
    public String moderateInfection;

    @ColumnInfo(name = "highInfection")
    public String highInfection;

    public Remedy() {
        // Empty constructor
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

    @Override
    public String toString() {
        return "Remedy{" +
                "uid=" + uid +
                ", CropName='" + CropName + '\'' +
                ", Disease='" + Disease + '\'' +
                ", Cause='" + Cause + '\'' +
                ", Indicator='" + Indicator + '\'' +
                ", lowInfection='" + lowInfection + '\'' +
                ", moderateInfection='" + moderateInfection + '\'' +
                ", highInfection='" + highInfection + '\'' +
                '}';
    }

    public Remedy(int uid, String cropName, String disease, String cause, String indicator, String lowInfection, String moderateInfection, String highInfection) {
        this.uid = uid;
        CropName = cropName;
        Disease = disease;
        Cause = cause;
        Indicator = indicator;

        this.lowInfection = lowInfection;
        this.moderateInfection = moderateInfection;
        this.highInfection = highInfection;
    }

    public String getLowInfection() {
        return lowInfection;
    }

    public void setLowInfection(String lowInfection) {
        this.lowInfection = lowInfection;
    }

    public String getModerateInfection() {
        return moderateInfection;
    }

    public void setModerateInfection(String moderateInfection) {
        this.moderateInfection = moderateInfection;
    }

    public String getHighInfection() {
        return highInfection;
    }

    public void setHighInfection(String highInfection) {
        this.highInfection = highInfection;
    }

    public static Remedy[] populateData() {
        return new Remedy[] {
               new Remedy(0, "Apple", "Apple Scab", "fungus Venturia inaequalis", " On the lower side of the leaf lesion appear as olivaceous spots which turn dark brown to black and become velvety.", "Dormant oil spray: Apply a horticultural oil spray during the dormant period to smother overwintering spores on the bark OR Copper fungicide: Apply a copper fungicide spray early in the season, just as the buds start to swell.", "Captan or mancozeb fungicide: Apply a fungicide spray just before the buds break and repeat every 7 to 10 days throughout the growing season OR Triadimefon or myclobutanil fungicide: Apply a systemic fungicide after petal fall and repeat every 10 to 14 days as necessary.", "Chlorothalonil fungicide: Apply a broad-spectrum fungicide at the first sign of disease and repeat every 7 to 10 days throughout the growing season OR Thiophanate-methyl fungicide: Apply a systemic fungicide every 10 to 14 days throughout the growing season."),

                new Remedy(1, "Apple", "Black Rot", " Diplodia seriata (syn Botryosphaeria obtusa)","Infected leaves develop frog-eye leaf spot. These are circular spots with reddish edges and light tan interiors.", "Lime sulfur spray: Apply a lime sulfur spray during the dormant period to control overwintering fungal spores OR Copper fungicide: Apply a copper fungicide spray early in the season, just as the buds start to swell.", "Captan or mancozeb fungicide: Apply a fungicide spray just before the buds break and repeat every 7 to 10 days throughout the growing season OR Chlorothalonil fungicide: Apply a broad-spectrum fungicide at the first sign of disease and repeat every 7 to 10 days throughout the growing season.", "Pyraclostrobin or boscalid fungicide: Apply a systemic fungicide after petal fall and repeat every 10 to 14 days as necessary OR Thiophanate-methyl fungicide: Apply a systemic fungicide every 10 to 14 days throughout the growing season."),

                new Remedy(2, "Apple", "Cedar Apple Rust", "Gymnosporangium juniperi-virginianae", "This disease first appears on apple leaves as small greenish yellow spots. The spots gradually enlarge and change colour to orange-yellow.", "Lime sulfur spray during the dormant period to control overwintering fungal spores OR Copper fungicide spray early in the season, just as the buds start to swell.", "Chlorothalonil fungicide spray just before the buds break and repeat every 7 to 10 days throughout the growing season OR Captan or mancozeb fungicide at the first sign of disease and repeat every 7 to 10 days throughout the growing season.", "Myclobutanil or triadimefon systemic fungicide after petal fall and repeat every 10 to 14 days as necessary OR Thiophanate-methyl systemic fungicide every 10 to 14 days throughout the growing season."),

                new Remedy(3," Apple","Healthy","-","-","-","-","-"),

                new Remedy(4, "Blackgram", "Anthracnose", "C. lindemuthianum", " Symptoms are circular, black, sunken spots with dark center and bright red orange margins on leaves and pods.","Fungicide: Mancozeb (75% WP) - 2-3 g/liter of water.","Fungicide: Propiconazole (14.3% EC) - 0.2-0.3 ml/liter of water.","Fungicide: Zineb (75% WP) - 2-3 g/liter of water."),

                new Remedy(5," Blackgram","Healthy ","-","-","-","-","-"),

                new Remedy(6, "Blackgram", "Leaf Crinkle", "Urdbean leaf crinkle virus (ULCV)", " The earliest symptoms appear on youngest leaves as chlorosis around some lateral veins and its branches near the margin. The leaves show curling of margin downwards. Some of the leaves show twisting. The veins show reddish brown discolouration on the under surface which also extends to the petiole.","Fungicides like mancozeb, propiconazole, or carbendazim can be used as preventative sprays to prevent the spread of the disease.","Fungicides like tebuconazole, propiconazole, or hexaconazole can be used to control the spread of the disease and protect the remaining healthy leaves.","Fungicides like pyraclostrobin, azoxystrobin, or trifloxystrobin can be used to control the spread of the disease and protect the remaining healthy leaves."),

                new Remedy(7, "Blackgram", "Powdery Mildew", "Erysiphe polygoni", "White powdery patches appear on leaves and other green parts which later become dull coloured. These patches gradually increase in size and become circular covering the lower surface also. When the infection is severe, both the surfaces of the leaves are completely covered by whitish powdery growth. Severely affected parts get shriveled and distorted. In severe infections, foliage becomes yellow causing premature defoliation. The disease also creates forced maturity of the infected plants which results in heavy yield losses.","Preventative fungicides like sulfur, potassium bicarbonate, or neem oil are typically used at a rate of 0.5-2% in water.","Fungicides like trifloxystrobin, myclobutanil, or tebuconazole are typically used at a rate of 0.25-0.5% in water.","Fungicides may be used at higher rates or in combination with other fungicides. It is best to consult with a local extension service or agricultural specialist for the best course of action for your specific situation."),

                new Remedy(8, "Blackgram", "Yellow Mosaic", "Mungbean Yellow Mosaic Virus", "Initially mild scattered yellow spots appear on young leaves. The next trifoliate leaves emerging from the growing apex show irregular yellow and green patches alternating with each other. Spots gradually increase in size and ultimately some leaves turn completely yellow.","Low infection: Mancozeb, Chlorothalonil, Copper oxychloride","Moderate infection: Carboxin, Carbendazim","High infection: Propiconazole, Tebuconazole"),

                new Remedy(9, "Grape", "Black Rot", "Guignardia bidwellii", "Reddish brown and circular to angular spots appear on the upper surface of the leaves starting in late spring. As spots merge, they form irregular, reddish brown blotches. The center of the leaf spot turns tannish brown and is surrounded by a black margin.","Lime sulfur spray during the dormant period to control overwintering fungal spores OR Copper fungicide spray early in the season, just as the buds start to swell.","Captan or mancozeb fungicide spray just before bloom and repeat every 7 to 10 days throughout the growing season OR Chlorothalonil fungicide apply at the first sign of disease and repeat every 7 to 10 days throughout the growing season.","Pyraclostrobin or boscalid systemic fungicide after bloom and repeat every 10 to 14 days as necessary OR Metconazole or myclobutanil systemic fungicide every 10 to 14 days throughout the growing season."),

                new Remedy(10, "Grape", "Esca (Black Measles)", "Phaeoacremonium aleophilum and Phaeomoniella chlamydospora", "The 'stripes', which start out as dark red in red cultivars and yellow in white cultivars, dry and become necrotic.","Lime sulfur spray during the dormant period to control overwintering fungal spores OR Copper fungicide spray early in the season, just as the buds start to swell.","Bordeaux mixture: Apply a copper-based fungicide just before bloom and repeat every 2 to 3 weeks until veraison OR Trifloxystrobin or azoxystrobin fungicide: Apply a systemic fungicide at veraison and repeat every 2 to 3 weeks until harvest.","Propiconazole or tebuconazole fungicide: Apply a systemic fungicide at veraison and repeat every 2 to 3 weeks until harvest OR Thiophanate-methyl or pyraclostrobin fungicide: Apply a systemic fungicide every 2 to 3 weeks throughout the growing season."),

                new Remedy(11,"Grape ","Healthy","-","-","-","-","-"),

                new Remedy(12, "Grape", "Leaf Blight (Isariopsis Leaf Spot)", "Pseudocercospora vitis", "On leaf surface we will see lesions which are irregularly shaped (2 to 25 mm in diameter). Initially lesions are dull red to brown in color turn black later.","Copper fungicide: Apply a copper fungicide spray early in the season, just as the buds start to swell OR Sulfur fungicide: Apply a sulfur-based fungicide in early to mid-season. ","Chlorothalonil fungicide: Apply a broad-spectrum fungicide at the first sign of disease and repeat every 7 to 10 days throughout the growing season OR Captan or mancozeb fungicide: Apply a broad-spectrum fungicide at the first sign of disease and repeat every 7 to 10 days throughout the growing season.","Myclobutanil or tebuconazole fungicide: Apply a systemic fungicide after bloom and repeat every 10 to 14 days as necessary OR Azoxystrobin or pyraclostrobin fungicide: Apply a systemic fungicide every 10 to 14 days throughout the growing season."),

                new Remedy(13,"Potato","Early Blight","Alternaria solani.","Brown-black necrotic spot-angular, oval shape characterized by concentric rings. Several spot coalesce & spread all over the leaf."," Azoxystrobin: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days OR Tebuconazole: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days OR Propiconazole: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days.", "Difenoconazole: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days OR Flutriafol: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days OR Azoxystrobin: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days.", "Trifloxystrobin: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days OR Epoxiconazole: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days OR Tebuconazole: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days."),

                new Remedy(14,"Potato "," Healthy ","-","-","-","-","-"),

                new Remedy(15,"Potato","Late Blight","Phytophthora infestans","Water soaked spots appear on leaves, increase in size, turn purple brown & finally black color. White growth develops on the under surface of leaves.","Mancozeb OR Copper fungicides OR Chlorothalonil","Mancozeb OR Copper fungicides OR Chlorothalonil OR Streptomycin, Azoxystrobin OR Propamocarb","Mancozeb OR Copper fungicides OR Chlorothalonil, Streptomycin OR Azoxystrobin OR Propamocarb OR Metalaxyl"),

                new Remedy(16, "Tomato", "Bacterial Spot", "Xanthomonas axonopodis pv. vesicatoria", "Small, brown, water-soaked, circular spots with a yellow halo on leaves.","Copper-based fungicides like copper sulfate OR copper hydroxide at a concentration of 0.5-1%.","The bactericide streptomycin at a concentration of 100-200 ppm.","The recommended concentration for streptomycin or oxolinic acid in cases of severe infection will depend on the severity of the infection and the specific fungicide used."),

                new Remedy(17, "Tomato", "Early Blight", "Alternaria solani", "Brown spots with concentric rings in a bull's eye pattern with yellow margin.","Mancozeb: Apply at a rate of 1.5-3 lb/acre, or as directed by the label OR Chlorothalonil: Apply at a rate of 4-6 lb/acre, or as directed by the label OR Copper fungicides: Apply at a rate of 2-4 lb/acre, or as directed by the label.","Azoxystrobin: Apply at a rate of 4-8 oz/acre, or as directed by the label OR Mancozeb: Apply at a rate of 1.5-3 lb/acre, or as directed by the label OR Chlorothalonil: Apply at a rate of 4-6 lb/acre, or as directed by the label.","Fludioxonil: Apply at a rate of 2-4 oz/acre, or as directed by the label OR Mefenoxam: Apply at a rate of 2-4 oz/acre, or as directed by the label OR Azoxystrobin: Apply at a rate of 4-8 oz/acre, or as directed by the label."),

                new Remedy(18," Tomato"," Healthy ","-","-","-","-","-"),

                new Remedy(19, "Tomato", "Late Blight", "Phytophthora infestans", "Water-soaked black lesions on leaves and stems. Lesions expand rapidly and the entire leaf becomes necrotic. White sporulation (sporangia and sporangiophores) on leaves.","Fungicide: Mancozeb (0.5-1.0%) OR Fungicide: Chlorothalonil (0.5-1.0%) OR Fungicide: Copper Sulfate (0.5-1.0%).","Fungicide: Mefenoxam (0.1-0.2%) OR Fungicide: Azoxystrobin (0.1-0.2%) OR Fungicide: Mandipropamid (0.1-0.2%).","Fungicide: Cymoxanil (0.1-0.2%) OR Fungicide: Propamocarb (0.1-0.2%) OR Fungicide: Metiram (0.1-0.2%)."),

                new Remedy(20, "Tomato", "Septoria Leaf Spot", "Septoria lycopersici", "Small, round to irregular spots with grey centre and dark margin on leaves. Spots coalesce and leaves are blighted.","Chlorothalonil: Apply a 0.5% solution every 7-10 days OR Mancozeb: Apply a 0.5% solution every 7-10 days OR Copper fungicides: Apply a 0.5% solution every 7-10 days","Azoxystrobin: Apply a 0.01% solution OR Propiconazole: Apply a 0.01% solution","Azoxystrobin: Apply a 0.01% solution OR Propiconazole: Apply a 0.01% solution")



        };
    }

    public static Remedy getRemedyById(int uid) {
        // Create an array of Remedy objects
        Remedy[] remedies = {
                new Remedy(0, "Apple", "Apple Scab", "fungus Venturia inaequalis", " On the lower side of the leaf lesion appear as olivaceous spots which turn dark brown to black and become velvety.", "Dormant oil spray: Apply a horticultural oil spray during the dormant period to smother overwintering spores on the bark OR Copper fungicide: Apply a copper fungicide spray early in the season, just as the buds start to swell.", "Captan or mancozeb fungicide: Apply a fungicide spray just before the buds break and repeat every 7 to 10 days throughout the growing season OR Triadimefon or myclobutanil fungicide: Apply a systemic fungicide after petal fall and repeat every 10 to 14 days as necessary.", "Chlorothalonil fungicide: Apply a broad-spectrum fungicide at the first sign of disease and repeat every 7 to 10 days throughout the growing season OR Thiophanate-methyl fungicide: Apply a systemic fungicide every 10 to 14 days throughout the growing season."),

                new Remedy(1, "Apple", "Black Rot", " Diplodia seriata (syn Botryosphaeria obtusa)","Infected leaves develop frog-eye leaf spot. These are circular spots with reddish edges and light tan interiors.", "Lime sulfur spray: Apply a lime sulfur spray during the dormant period to control overwintering fungal spores OR Copper fungicide: Apply a copper fungicide spray early in the season, just as the buds start to swell.", "Captan or mancozeb fungicide: Apply a fungicide spray just before the buds break and repeat every 7 to 10 days throughout the growing season OR Chlorothalonil fungicide: Apply a broad-spectrum fungicide at the first sign of disease and repeat every 7 to 10 days throughout the growing season.", "Pyraclostrobin or boscalid fungicide: Apply a systemic fungicide after petal fall and repeat every 10 to 14 days as necessary OR Thiophanate-methyl fungicide: Apply a systemic fungicide every 10 to 14 days throughout the growing season."),

                new Remedy(2, "Apple", "Cedar Apple Rust", "Gymnosporangium juniperi-virginianae", "This disease first appears on apple leaves as small greenish yellow spots. The spots gradually enlarge and change colour to orange-yellow.", "Lime sulfur spray during the dormant period to control overwintering fungal spores OR Copper fungicide spray early in the season, just as the buds start to swell.", "Chlorothalonil fungicide spray just before the buds break and repeat every 7 to 10 days throughout the growing season OR Captan or mancozeb fungicide at the first sign of disease and repeat every 7 to 10 days throughout the growing season.", "Myclobutanil or triadimefon systemic fungicide after petal fall and repeat every 10 to 14 days as necessary OR Thiophanate-methyl systemic fungicide every 10 to 14 days throughout the growing season."),

                new Remedy(3," Apple","Healthy","-","-","-","-","-"),

                new Remedy(4, "Blackgram", "Anthracnose", "C. lindemuthianum", " Symptoms are circular, black, sunken spots with dark center and bright red orange margins on leaves and pods.","Fungicide: Mancozeb (75% WP) - 2-3 g/liter of water.","Fungicide: Propiconazole (14.3% EC) - 0.2-0.3 ml/liter of water.","Fungicide: Zineb (75% WP) - 2-3 g/liter of water."),

                new Remedy(5," Blackgram","Healthy ","-","-","-","-","-"),

                new Remedy(6, "Blackgram", "Leaf Crinkle", "Urdbean leaf crinkle virus (ULCV)", " The earliest symptoms appear on youngest leaves as chlorosis around some lateral veins and its branches near the margin. The leaves show curling of margin downwards. Some of the leaves show twisting. The veins show reddish brown discolouration on the under surface which also extends to the petiole.","Fungicides like mancozeb, propiconazole, or carbendazim can be used as preventative sprays to prevent the spread of the disease.","Fungicides like tebuconazole, propiconazole, or hexaconazole can be used to control the spread of the disease and protect the remaining healthy leaves.","Fungicides like pyraclostrobin, azoxystrobin, or trifloxystrobin can be used to control the spread of the disease and protect the remaining healthy leaves."),

                new Remedy(7, "Blackgram", "Powdery Mildew", "Erysiphe polygoni", "White powdery patches appear on leaves and other green parts which later become dull coloured. These patches gradually increase in size and become circular covering the lower surface also. When the infection is severe, both the surfaces of the leaves are completely covered by whitish powdery growth. Severely affected parts get shriveled and distorted. In severe infections, foliage becomes yellow causing premature defoliation. The disease also creates forced maturity of the infected plants which results in heavy yield losses.","Preventative fungicides like sulfur, potassium bicarbonate, or neem oil are typically used at a rate of 0.5-2% in water.","Fungicides like trifloxystrobin, myclobutanil, or tebuconazole are typically used at a rate of 0.25-0.5% in water.","Fungicides may be used at higher rates or in combination with other fungicides. It is best to consult with a local extension service or agricultural specialist for the best course of action for your specific situation."),

                new Remedy(8, "Blackgram", "Yellow Mosaic", "Mungbean Yellow Mosaic Virus", "Initially mild scattered yellow spots appear on young leaves. The next trifoliate leaves emerging from the growing apex show irregular yellow and green patches alternating with each other. Spots gradually increase in size and ultimately some leaves turn completely yellow.","Low infection: Mancozeb, Chlorothalonil, Copper oxychloride","Moderate infection: Carboxin, Carbendazim","High infection: Propiconazole, Tebuconazole"),

                new Remedy(9, "Grape", "Black Rot", "Guignardia bidwellii", "Reddish brown and circular to angular spots appear on the upper surface of the leaves starting in late spring. As spots merge, they form irregular, reddish brown blotches. The center of the leaf spot turns tannish brown and is surrounded by a black margin.","Lime sulfur spray during the dormant period to control overwintering fungal spores OR Copper fungicide spray early in the season, just as the buds start to swell.","Captan or mancozeb fungicide spray just before bloom and repeat every 7 to 10 days throughout the growing season OR Chlorothalonil fungicide apply at the first sign of disease and repeat every 7 to 10 days throughout the growing season.","Pyraclostrobin or boscalid systemic fungicide after bloom and repeat every 10 to 14 days as necessary OR Metconazole or myclobutanil systemic fungicide every 10 to 14 days throughout the growing season."),

                new Remedy(10, "Grape", "Esca (Black Measles)", "Phaeoacremonium aleophilum and Phaeomoniella chlamydospora", "The 'stripes', which start out as dark red in red cultivars and yellow in white cultivars, dry and become necrotic.","Lime sulfur spray during the dormant period to control overwintering fungal spores OR Copper fungicide spray early in the season, just as the buds start to swell.","Bordeaux mixture: Apply a copper-based fungicide just before bloom and repeat every 2 to 3 weeks until veraison OR Trifloxystrobin or azoxystrobin fungicide: Apply a systemic fungicide at veraison and repeat every 2 to 3 weeks until harvest.","Propiconazole or tebuconazole fungicide: Apply a systemic fungicide at veraison and repeat every 2 to 3 weeks until harvest OR Thiophanate-methyl or pyraclostrobin fungicide: Apply a systemic fungicide every 2 to 3 weeks throughout the growing season."),

                new Remedy(11,"Grape ","Healthy","-","-","-","-","-"),

                new Remedy(12, "Grape", "Leaf Blight (Isariopsis Leaf Spot)", "Pseudocercospora vitis", "On leaf surface we will see lesions which are irregularly shaped (2 to 25 mm in diameter). Initially lesions are dull red to brown in color turn black later.","Copper fungicide: Apply a copper fungicide spray early in the season, just as the buds start to swell OR Sulfur fungicide: Apply a sulfur-based fungicide in early to mid-season. ","Chlorothalonil fungicide: Apply a broad-spectrum fungicide at the first sign of disease and repeat every 7 to 10 days throughout the growing season OR Captan or mancozeb fungicide: Apply a broad-spectrum fungicide at the first sign of disease and repeat every 7 to 10 days throughout the growing season.","Myclobutanil or tebuconazole fungicide: Apply a systemic fungicide after bloom and repeat every 10 to 14 days as necessary OR Azoxystrobin or pyraclostrobin fungicide: Apply a systemic fungicide every 10 to 14 days throughout the growing season."),

                new Remedy(13,"Potato","Early Blight","Alternaria solani.","Brown-black necrotic spot-angular, oval shape characterized by concentric rings. Several spot coalesce & spread all over the leaf."," Azoxystrobin: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days OR Tebuconazole: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days OR Propiconazole: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days.", "Difenoconazole: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days OR Flutriafol: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days OR Azoxystrobin: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days.", "Trifloxystrobin: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days OR Epoxiconazole: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days OR Tebuconazole: Apply at a rate of 4 to 8 fluid ounces per 100 gallons of water every 7-14 days."),

                new Remedy(14,"Potato "," Healthy ","-","-","-","-","-"),

                new Remedy(15,"Potato","Late Blight","Phytophthora infestans","Water soaked spots appear on leaves, increase in size, turn purple brown & finally black color. White growth develops on the under surface of leaves.","Mancozeb OR Copper fungicides OR Chlorothalonil","Mancozeb OR Copper fungicides OR Chlorothalonil OR Streptomycin, Azoxystrobin OR Propamocarb","Mancozeb OR Copper fungicides OR Chlorothalonil, Streptomycin OR Azoxystrobin OR Propamocarb OR Metalaxyl"),

                new Remedy(16, "Tomato", "Bacterial Spot", "Xanthomonas axonopodis pv. vesicatoria", "Small, brown, water-soaked, circular spots with a yellow halo on leaves.","Copper-based fungicides like copper sulfate OR copper hydroxide at a concentration of 0.5-1%.","The bactericide streptomycin at a concentration of 100-200 ppm.","The recommended concentration for streptomycin or oxolinic acid in cases of severe infection will depend on the severity of the infection and the specific fungicide used."),

                new Remedy(17, "Tomato", "Early Blight", "Alternaria solani", "Brown spots with concentric rings in a bull's eye pattern with yellow margin.","Mancozeb: Apply at a rate of 1.5-3 lb/acre, or as directed by the label OR Chlorothalonil: Apply at a rate of 4-6 lb/acre, or as directed by the label OR Copper fungicides: Apply at a rate of 2-4 lb/acre, or as directed by the label.","Azoxystrobin: Apply at a rate of 4-8 oz/acre, or as directed by the label OR Mancozeb: Apply at a rate of 1.5-3 lb/acre, or as directed by the label OR Chlorothalonil: Apply at a rate of 4-6 lb/acre, or as directed by the label.","Fludioxonil: Apply at a rate of 2-4 oz/acre, or as directed by the label OR Mefenoxam: Apply at a rate of 2-4 oz/acre, or as directed by the label OR Azoxystrobin: Apply at a rate of 4-8 oz/acre, or as directed by the label."),

                new Remedy(18," Tomato"," Healthy ","-","-","-","-","-"),

                new Remedy(19, "Tomato", "Late Blight", "Phytophthora infestans", "Water-soaked black lesions on leaves and stems. Lesions expand rapidly and the entire leaf becomes necrotic. White sporulation (sporangia and sporangiophores) on leaves.","Fungicide: Mancozeb (0.5-1.0%) OR Fungicide: Chlorothalonil (0.5-1.0%) OR Fungicide: Copper Sulfate (0.5-1.0%).","Fungicide: Mefenoxam (0.1-0.2%) OR Fungicide: Azoxystrobin (0.1-0.2%) OR Fungicide: Mandipropamid (0.1-0.2%).","Fungicide: Cymoxanil (0.1-0.2%) OR Fungicide: Propamocarb (0.1-0.2%) OR Fungicide: Metiram (0.1-0.2%)."),

                new Remedy(20, "Tomato", "Septoria Leaf Spot", "Septoria lycopersici", "Small, round to irregular spots with grey centre and dark margin on leaves. Spots coalesce and leaves are blighted.","Chlorothalonil: Apply a 0.5% solution every 7-10 days OR Mancozeb: Apply a 0.5% solution every 7-10 days OR Copper fungicides: Apply a 0.5% solution every 7-10 days","Azoxystrobin: Apply a 0.01% solution OR Propiconazole: Apply a 0.01% solution","Azoxystrobin: Apply a 0.01% solution OR Propiconazole: Apply a 0.01% solution")

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