import React, { Component } from 'react'
import AreaService from '../services/AreaService';

class UpdateAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateArea = this.updateArea.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        AreaService.getAreaById(this.state.id).then( (res) =>{
            let area = res.data;
            this.setState({
                multiplier: area.multiplier,
                unit: area.unit
            });
        });
    }

    updateArea = (e) => {
        e.preventDefault();
        let area = {
            areaId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('area => ' + JSON.stringify(area));
        console.log('id => ' + JSON.stringify(this.state.id));
        AreaService.updateArea(area).then( res => {
            this.props.history.push('/areas');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Area</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateArea}>Save</button>
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

export default UpdateAreaComponent
