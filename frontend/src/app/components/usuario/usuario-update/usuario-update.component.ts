import { Usuario } from "./../usuario.model";
import { Router, ActivatedRoute } from "@angular/router";
import { UsuarioService } from "./../usuario.service";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-usuario-update",
  templateUrl: "./usuario-update.component.html",
  styleUrls: ["./usuario-update.component.css"],
})
export class UsuarioUpdateComponent implements OnInit {
  usuario: Usuario;

  constructor(
    private usuarioService: UsuarioService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get("id");
    this.usuarioService.readById(id).subscribe((usuario) => {
      this.usuario = usuario;
    });
  }

  updateUsuario(): void {
    this.usuarioService.update(this.usuario).subscribe(() => {
      this.usuarioService.showMessage("Usuário atualizado com sucesso!");
      this.router.navigate(["/usuarios"]);
    });
  }

  cancel(): void {
    this.router.navigate(["/usuarios"]);
  }
}
