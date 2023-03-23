const personOne = {
  firstName: "John",
  lastName: "Doe",
};

const personTwo = Object.create(personOne);

const Person = function (firstName, lastName) {
  this.firstName = firstName;
  this.lastName = lastName;
};

const personThree = new Person("John", "Doe");

class PersonClass {
  constructor(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}

const personFour = new PersonClass("John", "Doe");

class GameObject {
  constructor(xPosition, yPosition, name, life) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    this.name = name;
    this.life = life;
  }

  decreaseLife(delta) {
    this.life -= delta;
    if (this.life < 0) this.life = 0;
  };

  move(deltaX, deltaY) {
    this.xPosition += deltaX;
    this.yPosition += deltaY;
  };

  isAlive() {
    return this.life > 0;
  };
}

const gamerOne = new GameObject(0, 0, "Player", 100);
const gamerTwo = new GameObject(0, 0, "Player", 100);

const Vehicle = {
  maxSpeed: 100,
  color: "red",
  model: "BMW",
  numberOfWheels: 4,

  drive: function(speed) {
    if (speed > this.maxSpeed) {
      console.log(`Sorry, ${this.model} of ${this.color} can't go that fast`);
      return;
    }

    console.log(
      `${this.model} of ${this.color} color driving at ${speed} km/h`
    );
  },
};

const Car = Object.create(Vehicle);
Car.numberOfSeats = 4;

const redPorsche = Object.create(Car);
redPorsche.color = "red";
redPorsche.model = "Porsche";

redPorsche.drive(200);
console.log(redPorsche.numberOfWheels);

const bike = Object.create(Vehicle);
bike.numberOfWheels = 2;

console.log(Vehicle.numberOfWheels);
console.log(redPorsche.numberOfWheels);
console.log(bike.numberOfWheels);

const person = {
  firstName: "John",
  lastName: "Doe",

  printName: function() {
    console.log(`${this.firstName} ${this.lastName}`);
  },
};

const student = {
  firstName: "Bat",
  lastName: "Man",
};

person.printName();
person.printName.apply(student);
