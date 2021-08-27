Included in here technical specifications and a description of the website

AnExcellentHost.com is an image hosting website. 
The primary use is to post an item for retrieval later (either to be linked to where a 
    direct upload is difficult) or as a form of external storage.
    
    Technical Specifications:
    I'm not sure what to write here. This should work on any modern browser and/or appliance.
    Uses HTML as the base, with some CSS to make it look pretty, and a little JS for added functionality.


CURRENT FUNCTIONALITY
Home Page:
	The images are the first 10 in the database. If you have just opened this project for the first time 
	with an empty database, this will look bare. Log in and upload a few, it doesn't matter what. 10MB max.
	Takes a little longer to load than a standard webpage, but overall is fine. Every pic can be clicked
	to go to its individual page. 
	A future build would have more images and also pages. Randomness might/might not be the final build. 
Login:
	Username and passwords are compeletely functional and hashed. Forgot Password function doesn't exist.
Create Account:
	Uses JS to verify the password and prevent a bad pageload. 
	The three non-account questions are just silly and otherwise the info goes nowhere. For now.
View:
	This is the bread and butter of the website. The pic is its true size if under certain dimensions.
	Otherwise it is restrained somewhat, scaled to fit the height. Tags can be added by the user on the left
	to better inform the user about certain things like artist, origin, etc, as well as be used in a 
	future search function which is so far not even attempted. Comments can also be left by the user
	which also attaches their username as well.
	Future build will have votes be counted once per account/session, automatically self-removing tags,
	reaction/like feature on image and comments, and a search function to find the image by name or tag.
Account:
	Here, the user can change their password or delete themselves. That's largely it.
	A future build will have the capability to change usernames, possibly profile pics, stats on the user's
	posts (likes, reacts, etc), and a list of every pic the user has posted, presented much like on Home.
	Possibility for friends lists.
	
	
Major Technical Challenges:
	Implementing Spring was ultimately the hardest part. Errors plagued the project from start to finish
	regarding either Spring Security or Boot. 
	Writing controller code was perhaps the most hard for me. Wrapping my head around the language was 
	difficult throughout.
	In terms of time, getting the actual image uploading done took the most. The example projects weren't
	just the kind where one could easily import the code and make it work. A lot of trials went through this
	feature.
User stories:
	As a user, I want to see my image on its own page and be able to comment on them so I can share how I feel.
	As a user, I want to be able to react or like comments and pictures so that I can show how I feel.
	As a user, I want to be able to log in and out so that I know I can find the images I posted before.
	As a user, I want to tag an image as a "favorite" so I can come back to it later.
	As a user, I want to upload my own pictures so I can keep them somewhere and show them to others.