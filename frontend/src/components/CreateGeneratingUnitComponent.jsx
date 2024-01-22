import React, { Component } from 'react'
import GeneratingUnitService from '../services/GeneratingUnitService';

class CreateGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                genControlSource: ''
        }
        this.changeGenControlSourceHandler = this.changeGenControlSourceHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GeneratingUnitService.getGeneratingUnitById(this.state.id).then( (res) =>{
                let generatingUnit = res.data;
                this.setState({
                    genControlSource: generatingUnit.genControlSource
                });
            });
        }        
    }
    saveOrUpdateGeneratingUnit = (e) => {
        e.preventDefault();
        let generatingUnit = {
                generatingUnitId: this.state.id,
                genControlSource: this.state.genControlSource
            };
        console.log('generatingUnit => ' + JSON.stringify(generatingUnit));

        // step 5
        if(this.state.id === '_add'){
            generatingUnit.generatingUnitId=''
            GeneratingUnitService.createGeneratingUnit(generatingUnit).then(res =>{
                this.props.history.push('/generatingUnits');
            });
        }else{
            GeneratingUnitService.updateGeneratingUnit(generatingUnit).then( res => {
                this.props.history.push('/generatingUnits');
            });
        }
    }
    
    changeGenControlSourceHandler= (event) => {
        this.setState({genControlSource: event.target.value});
    }

    cancel(){
        this.props.history.push('/generatingUnits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GeneratingUnit</h3>
        }else{
            return <h3 className="text-center">Update GeneratingUnit</h3>
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
                                            <label> GenControlSource: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGeneratingUnit}>Save</button>
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

export default CreateGeneratingUnitComponent
