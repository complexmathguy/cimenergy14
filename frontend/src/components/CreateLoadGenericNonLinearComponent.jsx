import React, { Component } from 'react'
import LoadGenericNonLinearService from '../services/LoadGenericNonLinearService';

class CreateLoadGenericNonLinearComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                genericNonLinearLoadModelType: ''
        }
        this.changeGenericNonLinearLoadModelTypeHandler = this.changeGenericNonLinearLoadModelTypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            LoadGenericNonLinearService.getLoadGenericNonLinearById(this.state.id).then( (res) =>{
                let loadGenericNonLinear = res.data;
                this.setState({
                    genericNonLinearLoadModelType: loadGenericNonLinear.genericNonLinearLoadModelType
                });
            });
        }        
    }
    saveOrUpdateLoadGenericNonLinear = (e) => {
        e.preventDefault();
        let loadGenericNonLinear = {
                loadGenericNonLinearId: this.state.id,
                genericNonLinearLoadModelType: this.state.genericNonLinearLoadModelType
            };
        console.log('loadGenericNonLinear => ' + JSON.stringify(loadGenericNonLinear));

        // step 5
        if(this.state.id === '_add'){
            loadGenericNonLinear.loadGenericNonLinearId=''
            LoadGenericNonLinearService.createLoadGenericNonLinear(loadGenericNonLinear).then(res =>{
                this.props.history.push('/loadGenericNonLinears');
            });
        }else{
            LoadGenericNonLinearService.updateLoadGenericNonLinear(loadGenericNonLinear).then( res => {
                this.props.history.push('/loadGenericNonLinears');
            });
        }
    }
    
    changeGenericNonLinearLoadModelTypeHandler= (event) => {
        this.setState({genericNonLinearLoadModelType: event.target.value});
    }

    cancel(){
        this.props.history.push('/loadGenericNonLinears');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LoadGenericNonLinear</h3>
        }else{
            return <h3 className="text-center">Update LoadGenericNonLinear</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> GenericNonLinearLoadModelType: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLoadGenericNonLinear}>Save</button>
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

export default CreateLoadGenericNonLinearComponent
