import React, { Component } from 'react'
import GeneratingUnitService from '../services/GeneratingUnitService';

class UpdateGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                genControlSource: ''
        }
        this.updateGeneratingUnit = this.updateGeneratingUnit.bind(this);

        this.changeGenControlSourceHandler = this.changeGenControlSourceHandler.bind(this);
    }

    componentDidMount(){
        GeneratingUnitService.getGeneratingUnitById(this.state.id).then( (res) =>{
            let generatingUnit = res.data;
            this.setState({
                genControlSource: generatingUnit.genControlSource
            });
        });
    }

    updateGeneratingUnit = (e) => {
        e.preventDefault();
        let generatingUnit = {
            generatingUnitId: this.state.id,
            genControlSource: this.state.genControlSource
        };
        console.log('generatingUnit => ' + JSON.stringify(generatingUnit));
        console.log('id => ' + JSON.stringify(this.state.id));
        GeneratingUnitService.updateGeneratingUnit(generatingUnit).then( res => {
            this.props.history.push('/generatingUnits');
        });
    }

    changeGenControlSourceHandler= (event) => {
        this.setState({genControlSource: event.target.value});
    }

    cancel(){
        this.props.history.push('/generatingUnits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GeneratingUnit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> GenControlSource: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGeneratingUnit}>Save</button>
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

export default UpdateGeneratingUnitComponent
