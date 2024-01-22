import React, { Component } from 'react'
import ACLineSegmentService from '../services/ACLineSegmentService'

class ListACLineSegmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                aCLineSegments: []
        }
        this.addACLineSegment = this.addACLineSegment.bind(this);
        this.editACLineSegment = this.editACLineSegment.bind(this);
        this.deleteACLineSegment = this.deleteACLineSegment.bind(this);
    }

    deleteACLineSegment(id){
        ACLineSegmentService.deleteACLineSegment(id).then( res => {
            this.setState({aCLineSegments: this.state.aCLineSegments.filter(aCLineSegment => aCLineSegment.aCLineSegmentId !== id)});
        });
    }
    viewACLineSegment(id){
        this.props.history.push(`/view-aCLineSegment/${id}`);
    }
    editACLineSegment(id){
        this.props.history.push(`/add-aCLineSegment/${id}`);
    }

    componentDidMount(){
        ACLineSegmentService.getACLineSegments().then((res) => {
            this.setState({ aCLineSegments: res.data});
        });
    }

    addACLineSegment(){
        this.props.history.push('/add-aCLineSegment/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ACLineSegment List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addACLineSegment}> Add ACLineSegment</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.aCLineSegments.map(
                                        aCLineSegment => 
                                        <tr key = {aCLineSegment.aCLineSegmentId}>
                                             <td>
                                                 <button onClick={ () => this.editACLineSegment(aCLineSegment.aCLineSegmentId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteACLineSegment(aCLineSegment.aCLineSegmentId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewACLineSegment(aCLineSegment.aCLineSegmentId)} className="btn btn-info btn-sm">View </button>
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

export default ListACLineSegmentComponent
