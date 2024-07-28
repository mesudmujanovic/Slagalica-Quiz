import { Field } from "./Field-interface";

export interface Association {
    id: number;
    fields: Field[];
    finalSolutions: string;
    solutions: {
        "A": string;
        "B": string;
        "C": string;
        "D": string;
    };
}