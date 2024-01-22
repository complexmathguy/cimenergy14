import React, { Component } from 'react'
import LoadGenericNonLinearService from '../services/LoadGenericNonLinearService';

class UpdateLoadGenericNonLinearComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                genericNonLinearLoadModelType: ''
        }
        this.updateLoadGenericNonLinear = this.updateLoadGenericNonLinear.bind(this);

        this.changeGenericNonLinearLoadModelTypeHandler = this.changeGenericNonLinearLoadModelTypeHandler.bind(this);
    }

    componentDidMount(){
        LoadGenericNonLinearService.getLoadGenericNonLinearById(this.state.id).then( (res) =>{
            let loadGenericNonLinear = res.data;
            this.setState({
                genericNonLinearLoadModelType: loadGenericNonLinear.genericNonLinearLoadModelType
            });
        });
    }

    updateLoadGenericNonLinear = (e) => {
        e.preventDefault();
        let loadGenericNonLinear = {
            loadGenericNonLinearId: this.state.id,
            genericNonLinearLoadModelType: this.state.genericNonLinearLoadModelType
        };
        console.log('loadGenericNonLinear => ' + JSON.stringify(loadGenericNonLinear));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadGenericNonLinearService.updateLoadGenericNonLinear(loadGenericNonLinear).then( res => {
            this.props.history.push('/loadGenericNonLinears');
        });
    }

    changeGenericNonLinearLoadModelTypeHandler= (event) => {
        this.setState({genericNonLinearLoadModelType: event.target.value});
    }

    cancel(){
        this.props.history.push('/loadGenericNonLinears');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadGenericNonLinear</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> GenericNonLinearLoadModelType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadGenericNonLinear}>Save</button>
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

export default UpdateLoadGenericNonLinearComponent
