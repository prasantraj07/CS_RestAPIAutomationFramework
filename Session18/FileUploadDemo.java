package Session18;

// Upload File in Rest Assured:
// Content-Type in case of FileUpload is 'multipart/form-data'

import java.io.File;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileUploadDemo 
{
	//Test 1:
	void uploadFile() 
	{
		//Create file object:
		
		File testFileUpload = new File("C:\\Users\\Asus\\Downloads\\TestDummyFile.txt");
		File testFileUpload2 = new File("C:\\Users\\Asus\\Downloads\\TestDummyFile02.txt");
		
		//create request specification:
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://httpbin.org/post");
		
		// for single file:
		//requestSpec.multiPart("file", testFileUpload);
		
		// for multiple files:
		requestSpec.multiPart("files", testFileUpload);
		requestSpec.multiPart("files", testFileUpload2);
		
		//Content-Type in case of File Upload:
		requestSpec.contentType("multipart/form-data");
		
		//perform Post request:
		Response response = requestSpec.post();
		
		response.prettyPrint();
		
		//validate status code:
		
		if(response.statusCode()==200) 
		{
			System.out.println("Correct status code");
		}
		else 
		{
			System.out.println("Incorrect status code");
		}
		
		
	}
	
	//Test 2:
	void uploadImage() 
	{
		
		//Create file object:
		
		File imageUpload = new File("C:\\Users\\Asus\\Downloads\\download.jpg");
						
		//create request specification:
		RequestSpecification requestSpec = RestAssured.given();
				
		requestSpec.baseUri("https://petstore.swagger.io/v2/pet/01/uploadImage");
				
		// for single file:
		requestSpec.multiPart("file", imageUpload);
		
		//Content-Type in case of File Upload:
		requestSpec.contentType("multipart/form-data");
				
		//perform Post request:
		Response response = requestSpec.post();
				
		response.prettyPrint();
				
		
	}
	
	public static void main(String[] args) 
	{
		FileUploadDemo obj = new FileUploadDemo();
		//obj.uploadFile();
		obj.uploadImage();
		
	}
	

}
