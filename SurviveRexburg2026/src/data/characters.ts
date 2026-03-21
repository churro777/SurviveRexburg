import { CharacterTemplate } from '../game/types';

export const CHARACTERS: CharacterTemplate[] = [
  { id: 'ben',    name: 'Ben',    strength: 10, speed: 5,  charisma: 1,  luck: 4,  hidden: false },
  { id: 'bing',   name: 'Bing',   strength: 6,  speed: 8,  charisma: 3,  luck: 3,  hidden: false },
  { id: 'hayley', name: 'Hayley', strength: 1,  speed: 5,  charisma: 6,  luck: 8,  hidden: false },
  { id: 'megan',  name: 'Megan',  strength: 6,  speed: 2,  charisma: 8,  luck: 4,  hidden: false },
  { id: 'nathan', name: 'Nathan', strength: 10, speed: 10, charisma: 10, luck: 10, hidden: true  },
];
