import React, { Component } from 'react'
import WindDynamicsLookupTableService from '../services/WindDynamicsLookupTableService';

class UpdateWindDynamicsLookupTableComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                lookupTableFunctionType: ''
        }
        this.updateWindDynamicsLookupTable = this.updateWindDynamicsLookupTable.bind(this);

        this.changeLookupTableFunctionTypeHandler = this.changeLookupTableFunctionTypeHandler.bind(this);
    }

    componentDidMount(){
        WindDynamicsLookupTableService.getWindDynamicsLookupTableById(this.state.id).then( (res) =>{
            let windDynamicsLookupTable = res.data;
            this.setState({
                lookupTableFunctionType: windDynamicsLookupTable.lookupTableFunctionType
            });
        });
    }

    updateWindDynamicsLookupTable = (e) => {
        e.preventDefault();
        let windDynamicsLookupTable = {
            windDynamicsLookupTableId: this.state.id,
            lookupTableFunctionType: this.state.lookupTableFunctionType
        };
        console.log('windDynamicsLookupTable => ' + JSON.stringify(windDynamicsLookupTable));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindDynamicsLookupTableService.updateWindDynamicsLookupTable(windDynamicsLookupTable).then( res => {
            this.props.history.push('/windDynamicsLookupTables');
        });
    }

    changeLookupTableFunctionTypeHandler= (event) => {
        this.setState({lookupTableFunctionType: event.target.value});
    }

    cancel(){
        this.props.history.push('/windDynamicsLookupTables');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindDynamicsLookupTable</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> LookupTableFunctionType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindDynamicsLookupTable}>Save</button>
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

export default UpdateWindDynamicsLookupTableComponent
