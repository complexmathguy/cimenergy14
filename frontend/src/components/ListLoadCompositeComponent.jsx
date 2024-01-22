import React, { Component } from 'react'
import LoadCompositeService from '../services/LoadCompositeService'

class ListLoadCompositeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                loadComposites: []
        }
        this.addLoadComposite = this.addLoadComposite.bind(this);
        this.editLoadComposite = this.editLoadComposite.bind(this);
        this.deleteLoadComposite = this.deleteLoadComposite.bind(this);
    }

    deleteLoadComposite(id){
        LoadCompositeService.deleteLoadComposite(id).then( res => {
            this.setState({loadComposites: this.state.loadComposites.filter(loadComposite => loadComposite.loadCompositeId !== id)});
        });
    }
    viewLoadComposite(id){
        this.props.history.push(`/view-loadComposite/${id}`);
    }
    editLoadComposite(id){
        this.props.history.push(`/add-loadComposite/${id}`);
    }

    componentDidMount(){
        LoadCompositeService.getLoadComposites().then((res) => {
            this.setState({ loadComposites: res.data});
        });
    }

    addLoadComposite(){
        this.props.history.push('/add-loadComposite/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">LoadComposite List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLoadComposite}> Add LoadComposite</button>
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
                                    this.state.loadComposites.map(
                                        loadComposite => 
                                        <tr key = {loadComposite.loadCompositeId}>
                                             <td>
                                                 <button onClick={ () => this.editLoadComposite(loadComposite.loadCompositeId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLoadComposite(loadComposite.loadCompositeId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLoadComposite(loadComposite.loadCompositeId)} className="btn btn-info btn-sm">View </button>
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

export default ListLoadCompositeComponent
