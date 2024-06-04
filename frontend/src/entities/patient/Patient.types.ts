type PatientDto = {
    id: number;
    name: string;
    species: Species;
    breed: string;
    birthDate: Date;
}

enum Species {
    BIRD = 'BIRD',
    CAT = 'CAT',
    COW = 'COW',
    DOG = 'DOG',
    FISH = 'FISH',
    HORSE = 'HORSE',
    OTHER = 'OTHER',
    RABBIT = 'RABBIT',
    RAT = 'RAT',
    REPTILE = 'REPTILE',
    RODENT = 'RODENT',
    SHEEP = 'SHEEP',
}

export type {PatientDto, Species}