import React, { Component } from 'react'
import GeneratingUnitService from '../services/GeneratingUnitService'

class ListGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                generatingUnits: []
        }
        this.addGeneratingUnit = this.addGeneratingUnit.bind(this);
        this.editGeneratingUnit = this.editGeneratingUnit.bind(this);
        this.deleteGeneratingUnit = this.deleteGeneratingUnit.bind(this);
    }

    deleteGeneratingUnit(id){
        GeneratingUnitService.deleteGeneratingUnit(id).then( res => {
            this.setState({generatingUnits: this.state.generatingUnits.filter(generatingUnit => generatingUnit.generatingUnitId !== id)});
        });
    }
    viewGeneratingUnit(id){
        this.props.history.push(`/view-generatingUnit/${id}`);
    }
    editGeneratingUnit(id){
        this.props.history.push(`/add-generatingUnit/${id}`);
    }

    componentDidMount(){
        GeneratingUnitService.getGeneratingUnits().then((res) => {
            this.setState({ generatingUnits: res.data});
        });
    }

    addGeneratingUnit(){
        this.props.history.push('/add-generatingUnit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GeneratingUnit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGeneratingUnit}> Add GeneratingUnit</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> GenControlSource </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.generatingUnits.map(
                                        generatingUnit => 
                                        <tr key = {generatingUnit.generatingUnitId}>
                                             <td> { generatingUnit.genControlSource } </td>
                                             <td>
                                                 <button onClick={ () => this.editGeneratingUnit(generatingUnit.generatingUnitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGeneratingUnit(generatingUnit.generatingUnitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGeneratingUnit(generatingUnit.generatingUnitId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListGeneratingUnitComponent
