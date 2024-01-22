import React, { Component } from 'react'
import PetersenCoilService from '../services/PetersenCoilService';

class UpdatePetersenCoilComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                mode: ''
        }
        this.updatePetersenCoil = this.updatePetersenCoil.bind(this);

        this.changeModeHandler = this.changeModeHandler.bind(this);
    }

    componentDidMount(){
        PetersenCoilService.getPetersenCoilById(this.state.id).then( (res) =>{
            let petersenCoil = res.data;
            this.setState({
                mode: petersenCoil.mode
            });
        });
    }

    updatePetersenCoil = (e) => {
        e.preventDefault();
        let petersenCoil = {
            petersenCoilId: this.state.id,
            mode: this.state.mode
        };
        console.log('petersenCoil => ' + JSON.stringify(petersenCoil));
        console.log('id => ' + JSON.stringify(this.state.id));
        PetersenCoilService.updatePetersenCoil(petersenCoil).then( res => {
            this.props.history.push('/petersenCoils');
        });
    }

    changeModeHandler= (event) => {
        this.setState({mode: event.target.value});
    }

    cancel(){
        this.props.history.push('/petersenCoils');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PetersenCoil</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Mode: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePetersenCoil}>Save</button>
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

export default UpdatePetersenCoilComponent
