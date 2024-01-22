import React, { Component } from 'react'
import LoadCompositeService from '../services/LoadCompositeService';

class UpdateLoadCompositeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateLoadComposite = this.updateLoadComposite.bind(this);

    }

    componentDidMount(){
        LoadCompositeService.getLoadCompositeById(this.state.id).then( (res) =>{
            let loadComposite = res.data;
            this.setState({
            });
        });
    }

    updateLoadComposite = (e) => {
        e.preventDefault();
        let loadComposite = {
            loadCompositeId: this.state.id,
        };
        console.log('loadComposite => ' + JSON.stringify(loadComposite));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadCompositeService.updateLoadComposite(loadComposite).then( res => {
            this.props.history.push('/loadComposites');
        });
    }


    cancel(){
        this.props.history.push('/loadComposites');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadComposite</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadComposite}>Save</button>
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

export default UpdateLoadCompositeComponent
