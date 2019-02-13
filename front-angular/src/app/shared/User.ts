import { Telefone } from './Telefone';

export class User {
    id: number;
    nome: string;
    email: string;
    senha: string;
    cpf: string;
    telefones: Telefone;
}