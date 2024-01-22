import React, { Component } from 'react'
import LoadCompositeService from '../services/LoadCompositeService';

class CreateLoadCompositeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            LoadCompositeService.getLoadCompositeById(this.state.id).then( (res) =>{
                let loadComposite = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateLoadComposite = (e) => {
        e.preventDefault();
        let loadComposite = {
                loadCompositeId: this.state.id,
            };
        console.log('loadComposite => ' + JSON.stringify(loadComposite));

        // step 5
        if(this.state.id === '_add'){
            loadComposite.loadCompositeId=''
            LoadCompositeService.createLoadComposite(loadComposite).then(res =>{
                this.props.history.push('/loadComposites');
            });
        }else{
            LoadCompositeService.updateLoadComposite(loadComposite).then( res => {
                this.props.history.push('/loadComposites');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/loadComposites');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LoadComposite</h3>
        }else{
            return <h3 className="text-center">Update LoadComposite</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLoadComposite}>Save</button>
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

export default CreateLoadCompositeComponent
