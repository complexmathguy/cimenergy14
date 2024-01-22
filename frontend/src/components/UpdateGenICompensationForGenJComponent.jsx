import React, { Component } from 'react'
import GenICompensationForGenJService from '../services/GenICompensationForGenJService';

class UpdateGenICompensationForGenJComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGenICompensationForGenJ = this.updateGenICompensationForGenJ.bind(this);

    }

    componentDidMount(){
        GenICompensationForGenJService.getGenICompensationForGenJById(this.state.id).then( (res) =>{
            let genICompensationForGenJ = res.data;
            this.setState({
            });
        });
    }

    updateGenICompensationForGenJ = (e) => {
        e.preventDefault();
        let genICompensationForGenJ = {
            genICompensationForGenJId: this.state.id,
        };
        console.log('genICompensationForGenJ => ' + JSON.stringify(genICompensationForGenJ));
        console.log('id => ' + JSON.stringify(this.state.id));
        GenICompensationForGenJService.updateGenICompensationForGenJ(genICompensationForGenJ).then( res => {
            this.props.history.push('/genICompensationForGenJs');
        });
    }


    cancel(){
        this.props.history.push('/genICompensationForGenJs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GenICompensationForGenJ</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGenICompensationForGenJ}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateGenICompensationForGenJComponent
