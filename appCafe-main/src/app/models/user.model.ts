export interface User {
    id: number;
    username: string;
    password?: string;
    email: string;
    phone?: string | null;
    createdAt?: string | null;
    updatedAt?: string | null;
}