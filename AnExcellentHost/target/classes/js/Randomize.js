// This SHOULD pull randomly from the entire images folder, but JS alone can't do that.
// Sources online say that this can be done with AJAX, but I can't implement that in so short a time.
// Putting these links down as a resource for myself later
// https://coderanch.com/t/441021/languages/Randomly-displaying-images-directory-JavaScript
// https://www.sitepoint.com/ajax-jquery/

//FUTURE ADD:
// image[x] = '<a href='page.html''><img src="thestuff"></a>'; to make them links to their own pages



let image = new ImageArray(36)
image[0] = 'sargeant Meow.png'
image[1] = 'MAD.gif'
image[2] = 'cultist.jpg'
image[3] = 'BustColors.jpg'
image[4] = 'ClamlySitting.jpg'
image[5] = 'cloud.jpg'
image[6] = 'fabric.jpg'
image[7] = 'headphones.jpg'
image[8] = 'ManInWindow.jpg'
image[9] = 'mom NO.png'
image[10] = 'ny.jpg'
image[11] = 'office.jpg'
image[12] = 'randomCode.jpg'
image[13] = 'SeattleNight.jpg'
image[14] = 'SeattleTwilight.jpg'
image[15] = 'shutupandmoney.gif'
image[16] = 'Stars.jpg'
image[17] = 'WiggleCat.gif'
image[18] = 'Brobot.jpg'
image[19] = 'Delta.jpg'
image[20] = 'cupcakes.jpg'
image[21] = 'handsomeBoi.jpg'
image[22] = 'storm.jpg'
image[23] = 'shore.jpg'
image[24] = 'sunset.jpg'
image[25] = 'Happybot.jpg'
image[26] = 'tinycake.jpg'
image[27] = 'bizza.jpg'
image[28] = 'burg.jpg'
image[29] = 'science.jpg'
image[30] = 'duck.jpg'
image[31] = 'moth.jpg'
image[32] = 'drone.jpg'
image[33] = 'flowers.jpg'
image[34] = 'rainbow.jpg'
image[35] = 'tour.jpg'

var imlocation = "./images/";
function ImageArray(n) {
    this.length = n;
    for (var i=1; i<=n; i++){
        this[i] = ' '
    }
	randomImage = image[Math.floor(Math.random()*image.length)];
	return randomImage;
}
//document.write('<img class="thumbnail" src="' + imlocation + randomImage + '">');


document.addEventListener('DOMContentLoaded', () => {
	Randomize()
}


