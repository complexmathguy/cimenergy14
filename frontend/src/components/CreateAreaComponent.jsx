import React, { Component } from 'react'
import AreaService from '../services/AreaService';

class CreateAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            AreaService.getAreaById(this.state.id).then( (res) =>{
                let area = res.data;
                this.setState({
                    multiplier: area.multiplier,
                    unit: area.unit
                });
            });
        }        
    }
    saveOrUpdateArea = (e) => {
        e.preventDefault();
        let area = {
                areaId: this.state.id,
                multiplier: this.state.multiplier,
                unit: this.state.unit
            };
        console.log('area => ' + JSON.stringify(area));

        // step 5
        if(this.state.id === '_add'){
            area.areaId=''
            AreaService.createArea(area).then(res =>{
                this.props.history.push('/areas');
            });
        }else{
            AreaService.updateArea(area).then( res => {
                this.props.history.push('/areas');
            });
        }
    }
    
    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/areas');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Area</h3>
        }else{
            return <h3 className="text-center">Update Area</h3>
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
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateArea}>Save</button>
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

export default CreateAreaComponent
