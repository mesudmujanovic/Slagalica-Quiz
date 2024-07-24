export interface Association {
    id: number;
    fields: {
        text: string;
        position: string;
    }[];
    finalSolutions: string[];
    solutions: {
        "Column A": string;
        "Column B": string;
        "Column C": string;
        "Column D": string;
    };
}