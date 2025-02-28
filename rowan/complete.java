int w = width;
int h = height;

//colours
color pink = color(236,204,204);
color red = color(180,52,92);
color mauve = color(156,124,132);
color black = color(4,28,52);
color maroon = color(84,36,60);
color white = color(229,236,236);
color navy = color(60,76,92);
color blue = color(158,172,180);
color light_navy = color(76,92,108);

Button[] buttons = new Button[] { 
  new Button(0,0,50,50, true),
  new Button(100,100,50,20, true)
};

void setup() {
  size(500,500);
}

void draw() {
  wheel();
  for (Button b : buttons) {
    b.drawy();
  }
}

void wheel() {
  String[] chores = {"kitchen", "mop", "hoover", "something", "idk"};
  rect(w/2, h/2, 50, 20, 30, 30, 30, 30);
  fill(255,0,0);
  ellipse(0, 0, width/2, height/2);
  fill(0,255,0);
  for (int i = 0; i < chores.length; i++) {
    rotate(TWO_PI/chores.length);
    textSize(width/20);
    text(chores[i], width/20, 0, 200, 200);
  }
}

void mouseClicked() {

}

class Button {
  int x; int y;
  int w; int h; 
  boolean show;
  Button(int x, int y, int w, int h, boolean show) {
    this.show = show;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }
  
  boolean clicked() {
    if ((mouseX >= x) && (mouseX <= x+w) && (mouseY >= y) && (mouseY <= y+h)) {
      return true;
    }
    return false;
  } 
  
  void drawy() {
    if (show) {
      stroke(navy);
      fill(light_navy);
      strokeWeight(5);
      rect(x,y,w,h,20,20,20,20);
    }
  }
}

class Slider extends Button {
  boolean enable = false;
  
  Slider(int x, int y, int w, int h, boolean show, boolean enable) {
    super(x, y, w, h, show);
    this.enable = enable;
  }

  void drawy() {
    if (show) {
    fill(60,76,92); //navy
    rect(50 + x,150 + y,300,75,20,20,20,20); //xpos,ypos,width,height,curve
    if(!enable) {
      fill(158,172,180); //blue
      rect(60 + x,160 + y,280,55,20,20,20,20);
      fill(229,236,236); //white
      ellipse(50+x+75/2,150+y+75/2,65,65);
    } else {
      fill(236,204,204); //pink
      rect(60 + x,160 + y,280,55,20,20,20,20);
      fill(229,236,236); //white
      ellipse(350+x-75/2,150+y+75/2,65,65);
    }
    }
  }
}
