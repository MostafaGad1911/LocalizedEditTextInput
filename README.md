# LocalizedEditText
Custom edit text that allow only one language 

[![](https://jitpack.io/v/MostafaGad1911/LocalizedEditTextInput.svg)](https://jitpack.io/#MostafaGad1911/LocalizedEditTextInput)

# Supported languages : <br>
       Arabic , English  
# Default language : <br>
       English 

# Examples :
``` xml 
       
    <mostafagad.projects.localizededittext.AndroidLocalizedEditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter text"
        android:textColorHint="@color/black"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:used_language="en" />

```


# Getting Started 
## Step 1: Add it to build.gradle (project level) at the end of repositories:

 ``` kotlin  
             allprojects 
               {
	              repositories 
		           {	
			       maven { url 'https://jitpack.io' }
		           }  
	           }
```          
        

## Step 2 : Add the dependency
 ``` kotlin  
        implementation 'com.github.MostafaGad1911:LocalizedEditTextInput:1.0.0'
        
```         


 <img src="https://user-images.githubusercontent.com/25991597/124929248-a357e380-e000-11eb-96b1-ded18087de80.gif"  width="300" height="550"   />


	   
