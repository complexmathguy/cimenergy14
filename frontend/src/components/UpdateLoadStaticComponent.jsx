import React, { Component } from 'react'
import LoadStaticService from '../services/LoadStaticService';

class UpdateLoadStaticComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                staticLoadModelType: ''
        }
        this.updateLoadStatic = this.updateLoadStatic.bind(this);

        this.changeStaticLoadModelTypeHandler = this.changeStaticLoadModelTypeHandler.bind(this);
    }

    componentDidMount(){
        LoadStaticService.getLoadStaticById(this.state.id).then( (res) =>{
            let loadStatic = res.data;
            this.setState({
                staticLoadModelType: loadStatic.staticLoadModelType
            });
        });
    }

    updateLoadStatic = (e) => {
        e.preventDefault();
        let loadStatic = {
            loadStaticId: this.state.id,
            staticLoadModelType: this.state.staticLoadModelType
        };
        console.log('loadStatic => ' + JSON.stringify(loadStatic));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadStaticService.updateLoadStatic(loadStatic).then( res => {
            this.props.history.push('/loadStatics');
        });
    }

    changeStaticLoadModelTypeHandler= (event) => {
        this.setState({staticLoadModelType: event.target.value});
    }

    cancel(){
        this.props.history.push('/loadStatics');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadStatic</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> StaticLoadModelType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadStatic}>Save</button>
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

export default UpdateLoadStaticComponent
