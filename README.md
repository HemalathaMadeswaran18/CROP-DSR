# CROP-DSR

CropDSR: A Crop Disease Classification, Severity Measurement and Remedy Recommendation System

CropDSR is an android mobile application which has the following features:

• The quality of images uploaded by the user are augmented and enhanced. The proposed enhancement algorithm has an average Structural Similarity Index score of 0.8.
• The enhanced images, after classification, are segmented. The cloud deployed segmentation technique is deployed on Google Cloud Platform using a Flask-API. The Mobilelite technique is deployed on the mobile phone using OpenCV library.
• The crops are classified using a modified EfficientNet + CBAM and have an accuracy of 98.67 percent.
• Transfer Learning is used on the pre-trained Crop Classification Modified EfficientNet + CBAM model. It has an accuracy of 98.85 percent.
• The severity of the disease is calculated after classifying the disease. The cloud deployed techniques uses more elaborate steps whereas the MobileLite technique uses fewer steps. The severity is returned to the user as “High”, “Moderate” or “Low” depending on the leaf’s infection.
76
• The remedy is provided to the user depending on the disease by using the information gathered from credible sources.
• A doubt-clarification chatbot is created which interacts with the user and provides them with a remedy for the crop’s diseases.

Languages Used:
Python, Java

Tools/Technologies Used:
Google Cloud Platform
SQLite Database
Android Studio
Visual Studio Code
Jupyter Notebook and Google Colab
