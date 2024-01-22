import React, { Component } from 'react'
import LoadStaticService from '../services/LoadStaticService'

class ListLoadStaticComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                loadStatics: []
        }
        this.addLoadStatic = this.addLoadStatic.bind(this);
        this.editLoadStatic = this.editLoadStatic.bind(this);
        this.deleteLoadStatic = this.deleteLoadStatic.bind(this);
    }

    deleteLoadStatic(id){
        LoadStaticService.deleteLoadStatic(id).then( res => {
            this.setState({loadStatics: this.state.loadStatics.filter(loadStatic => loadStatic.loadStaticId !== id)});
        });
    }
    viewLoadStatic(id){
        this.props.history.push(`/view-loadStatic/${id}`);
    }
    editLoadStatic(id){
        this.props.history.push(`/add-loadStatic/${id}`);
    }

    componentDidMount(){
        LoadStaticService.getLoadStatics().then((res) => {
            this.setState({ loadStatics: res.data});
        });
    }

    addLoadStatic(){
        this.props.history.push('/add-loadStatic/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">LoadStatic List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLoadStatic}> Add LoadStatic</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> StaticLoadModelType </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.loadStatics.map(
                                        loadStatic => 
                                        <tr key = {loadStatic.loadStaticId}>
                                             <td> { loadStatic.staticLoadModelType } </td>
                                             <td>
                                                 <button onClick={ () => this.editLoadStatic(loadStatic.loadStaticId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLoadStatic(loadStatic.loadStaticId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLoadStatic(loadStatic.loadStaticId)} className="btn btn-info btn-sm">View </button>
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

export default ListLoadStaticComponent
