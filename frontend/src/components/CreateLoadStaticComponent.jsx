import React, { Component } from 'react'
import LoadStaticService from '../services/LoadStaticService';

class CreateLoadStaticComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                staticLoadModelType: ''
        }
        this.changeStaticLoadModelTypeHandler = this.changeStaticLoadModelTypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            LoadStaticService.getLoadStaticById(this.state.id).then( (res) =>{
                let loadStatic = res.data;
                this.setState({
                    staticLoadModelType: loadStatic.staticLoadModelType
                });
            });
        }        
    }
    saveOrUpdateLoadStatic = (e) => {
        e.preventDefault();
        let loadStatic = {
                loadStaticId: this.state.id,
                staticLoadModelType: this.state.staticLoadModelType
            };
        console.log('loadStatic => ' + JSON.stringify(loadStatic));

        // step 5
        if(this.state.id === '_add'){
            loadStatic.loadStaticId=''
            LoadStaticService.createLoadStatic(loadStatic).then(res =>{
                this.props.history.push('/loadStatics');
            });
        }else{
            LoadStaticService.updateLoadStatic(loadStatic).then( res => {
                this.props.history.push('/loadStatics');
            });
        }
    }
    
    changeStaticLoadModelTypeHandler= (event) => {
        this.setState({staticLoadModelType: event.target.value});
    }

    cancel(){
        this.props.history.push('/loadStatics');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LoadStatic</h3>
        }else{
            return <h3 className="text-center">Update LoadStatic</h3>
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
                                            <label> StaticLoadModelType: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLoadStatic}>Save</button>
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

export default CreateLoadStaticComponent
