/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcPIC as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcPIC are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcPICAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excPIC")
@Component("excPIC-projector")
public class ExcPICProjector extends ExcPICEntityProjector {

  // core constructor
  public ExcPICProjector(ExcPICRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcPICEvent
   */
  @EventHandler(payloadType = CreateExcPICEvent.class)
  public void handle(CreateExcPICEvent event) {
    LOGGER.info("handling CreateExcPICEvent - " + event);
    ExcPIC entity = new ExcPIC();
    entity.setExcPICId(event.getExcPICId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UpdateExcPICEvent
   */
  @EventHandler(payloadType = UpdateExcPICEvent.class)
  public void handle(UpdateExcPICEvent event) {
    LOGGER.info("handling UpdateExcPICEvent - " + event);

    ExcPIC entity = new ExcPIC();
    entity.setExcPICId(event.getExcPICId());
    entity.setE1(event.getE1());
    entity.setE2(event.getE2());
    entity.setEfdmax(event.getEfdmax());
    entity.setEfdmin(event.getEfdmin());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setSe1(event.getSe1());
    entity.setSe2(event.getSe2());
    entity.setTa1(event.getTa1());
    entity.setTa2(event.getTa2());
    entity.setTa3(event.getTa3());
    entity.setTa4(event.getTa4());
    entity.setTe(event.getTe());
    entity.setTf1(event.getTf1());
    entity.setTf2(event.getTf2());
    entity.setVr1(event.getVr1());
    entity.setVr2(event.getVr2());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event DeleteExcPICEvent
   */
  @EventHandler(payloadType = DeleteExcPICEvent.class)
  public void handle(DeleteExcPICEvent event) {
    LOGGER.info("handling DeleteExcPICEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcPIC entity = delete(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignE1ToExcPICEvent
   */
  @EventHandler(payloadType = AssignE1ToExcPICEvent.class)
  public void handle(AssignE1ToExcPICEvent event) {
    LOGGER.info("handling AssignE1ToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignE1(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignE1FromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignE1FromExcPICEvent.class)
  public void handle(UnAssignE1FromExcPICEvent event) {
    LOGGER.info("handling UnAssignE1FromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignE1(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignE2ToExcPICEvent
   */
  @EventHandler(payloadType = AssignE2ToExcPICEvent.class)
  public void handle(AssignE2ToExcPICEvent event) {
    LOGGER.info("handling AssignE2ToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignE2(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignE2FromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignE2FromExcPICEvent.class)
  public void handle(UnAssignE2FromExcPICEvent event) {
    LOGGER.info("handling UnAssignE2FromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignE2(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignEfdmaxToExcPICEvent
   */
  @EventHandler(payloadType = AssignEfdmaxToExcPICEvent.class)
  public void handle(AssignEfdmaxToExcPICEvent event) {
    LOGGER.info("handling AssignEfdmaxToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignEfdmax(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignEfdmaxFromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignEfdmaxFromExcPICEvent.class)
  public void handle(UnAssignEfdmaxFromExcPICEvent event) {
    LOGGER.info("handling UnAssignEfdmaxFromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignEfdmax(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignEfdminToExcPICEvent
   */
  @EventHandler(payloadType = AssignEfdminToExcPICEvent.class)
  public void handle(AssignEfdminToExcPICEvent event) {
    LOGGER.info("handling AssignEfdminToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignEfdmin(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignEfdminFromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignEfdminFromExcPICEvent.class)
  public void handle(UnAssignEfdminFromExcPICEvent event) {
    LOGGER.info("handling UnAssignEfdminFromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignEfdmin(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignKaToExcPICEvent
   */
  @EventHandler(payloadType = AssignKaToExcPICEvent.class)
  public void handle(AssignKaToExcPICEvent event) {
    LOGGER.info("handling AssignKaToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignKa(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignKaFromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcPICEvent.class)
  public void handle(UnAssignKaFromExcPICEvent event) {
    LOGGER.info("handling UnAssignKaFromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignKa(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignKcToExcPICEvent
   */
  @EventHandler(payloadType = AssignKcToExcPICEvent.class)
  public void handle(AssignKcToExcPICEvent event) {
    LOGGER.info("handling AssignKcToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignKc(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignKcFromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcPICEvent.class)
  public void handle(UnAssignKcFromExcPICEvent event) {
    LOGGER.info("handling UnAssignKcFromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignKc(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignKeToExcPICEvent
   */
  @EventHandler(payloadType = AssignKeToExcPICEvent.class)
  public void handle(AssignKeToExcPICEvent event) {
    LOGGER.info("handling AssignKeToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignKe(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignKeFromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcPICEvent.class)
  public void handle(UnAssignKeFromExcPICEvent event) {
    LOGGER.info("handling UnAssignKeFromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignKe(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignKfToExcPICEvent
   */
  @EventHandler(payloadType = AssignKfToExcPICEvent.class)
  public void handle(AssignKfToExcPICEvent event) {
    LOGGER.info("handling AssignKfToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignKf(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignKfFromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcPICEvent.class)
  public void handle(UnAssignKfFromExcPICEvent event) {
    LOGGER.info("handling UnAssignKfFromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignKf(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignKiToExcPICEvent
   */
  @EventHandler(payloadType = AssignKiToExcPICEvent.class)
  public void handle(AssignKiToExcPICEvent event) {
    LOGGER.info("handling AssignKiToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignKi(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignKiFromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignKiFromExcPICEvent.class)
  public void handle(UnAssignKiFromExcPICEvent event) {
    LOGGER.info("handling UnAssignKiFromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignKi(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignKpToExcPICEvent
   */
  @EventHandler(payloadType = AssignKpToExcPICEvent.class)
  public void handle(AssignKpToExcPICEvent event) {
    LOGGER.info("handling AssignKpToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignKp(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignKpFromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignKpFromExcPICEvent.class)
  public void handle(UnAssignKpFromExcPICEvent event) {
    LOGGER.info("handling UnAssignKpFromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignKp(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignSe1ToExcPICEvent
   */
  @EventHandler(payloadType = AssignSe1ToExcPICEvent.class)
  public void handle(AssignSe1ToExcPICEvent event) {
    LOGGER.info("handling AssignSe1ToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignSe1(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignSe1FromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignSe1FromExcPICEvent.class)
  public void handle(UnAssignSe1FromExcPICEvent event) {
    LOGGER.info("handling UnAssignSe1FromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignSe1(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignSe2ToExcPICEvent
   */
  @EventHandler(payloadType = AssignSe2ToExcPICEvent.class)
  public void handle(AssignSe2ToExcPICEvent event) {
    LOGGER.info("handling AssignSe2ToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignSe2(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignSe2FromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignSe2FromExcPICEvent.class)
  public void handle(UnAssignSe2FromExcPICEvent event) {
    LOGGER.info("handling UnAssignSe2FromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignSe2(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignTa1ToExcPICEvent
   */
  @EventHandler(payloadType = AssignTa1ToExcPICEvent.class)
  public void handle(AssignTa1ToExcPICEvent event) {
    LOGGER.info("handling AssignTa1ToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignTa1(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignTa1FromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignTa1FromExcPICEvent.class)
  public void handle(UnAssignTa1FromExcPICEvent event) {
    LOGGER.info("handling UnAssignTa1FromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignTa1(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignTa2ToExcPICEvent
   */
  @EventHandler(payloadType = AssignTa2ToExcPICEvent.class)
  public void handle(AssignTa2ToExcPICEvent event) {
    LOGGER.info("handling AssignTa2ToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignTa2(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignTa2FromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignTa2FromExcPICEvent.class)
  public void handle(UnAssignTa2FromExcPICEvent event) {
    LOGGER.info("handling UnAssignTa2FromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignTa2(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignTa3ToExcPICEvent
   */
  @EventHandler(payloadType = AssignTa3ToExcPICEvent.class)
  public void handle(AssignTa3ToExcPICEvent event) {
    LOGGER.info("handling AssignTa3ToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignTa3(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignTa3FromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignTa3FromExcPICEvent.class)
  public void handle(UnAssignTa3FromExcPICEvent event) {
    LOGGER.info("handling UnAssignTa3FromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignTa3(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignTa4ToExcPICEvent
   */
  @EventHandler(payloadType = AssignTa4ToExcPICEvent.class)
  public void handle(AssignTa4ToExcPICEvent event) {
    LOGGER.info("handling AssignTa4ToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignTa4(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignTa4FromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignTa4FromExcPICEvent.class)
  public void handle(UnAssignTa4FromExcPICEvent event) {
    LOGGER.info("handling UnAssignTa4FromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignTa4(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignTeToExcPICEvent
   */
  @EventHandler(payloadType = AssignTeToExcPICEvent.class)
  public void handle(AssignTeToExcPICEvent event) {
    LOGGER.info("handling AssignTeToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignTe(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignTeFromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcPICEvent.class)
  public void handle(UnAssignTeFromExcPICEvent event) {
    LOGGER.info("handling UnAssignTeFromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignTe(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignTf1ToExcPICEvent
   */
  @EventHandler(payloadType = AssignTf1ToExcPICEvent.class)
  public void handle(AssignTf1ToExcPICEvent event) {
    LOGGER.info("handling AssignTf1ToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignTf1(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignTf1FromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignTf1FromExcPICEvent.class)
  public void handle(UnAssignTf1FromExcPICEvent event) {
    LOGGER.info("handling UnAssignTf1FromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignTf1(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignTf2ToExcPICEvent
   */
  @EventHandler(payloadType = AssignTf2ToExcPICEvent.class)
  public void handle(AssignTf2ToExcPICEvent event) {
    LOGGER.info("handling AssignTf2ToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignTf2(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignTf2FromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignTf2FromExcPICEvent.class)
  public void handle(UnAssignTf2FromExcPICEvent event) {
    LOGGER.info("handling UnAssignTf2FromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignTf2(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignVr1ToExcPICEvent
   */
  @EventHandler(payloadType = AssignVr1ToExcPICEvent.class)
  public void handle(AssignVr1ToExcPICEvent event) {
    LOGGER.info("handling AssignVr1ToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignVr1(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignVr1FromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignVr1FromExcPICEvent.class)
  public void handle(UnAssignVr1FromExcPICEvent event) {
    LOGGER.info("handling UnAssignVr1FromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignVr1(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignVr2ToExcPICEvent
   */
  @EventHandler(payloadType = AssignVr2ToExcPICEvent.class)
  public void handle(AssignVr2ToExcPICEvent event) {
    LOGGER.info("handling AssignVr2ToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignVr2(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignVr2FromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignVr2FromExcPICEvent.class)
  public void handle(UnAssignVr2FromExcPICEvent event) {
    LOGGER.info("handling UnAssignVr2FromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignVr2(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignVrmaxToExcPICEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcPICEvent.class)
  public void handle(AssignVrmaxToExcPICEvent event) {
    LOGGER.info("handling AssignVrmaxToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignVrmax(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcPICEvent.class)
  public void handle(UnAssignVrmaxFromExcPICEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignVrmax(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event AssignVrminToExcPICEvent
   */
  @EventHandler(payloadType = AssignVrminToExcPICEvent.class)
  public void handle(AssignVrminToExcPICEvent event) {
    LOGGER.info("handling AssignVrminToExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcPIC entity = assignVrmin(event.getExcPICId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcPICEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcPICEvent.class)
  public void handle(UnAssignVrminFromExcPICEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcPICEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcPIC entity = unAssignVrmin(event.getExcPICId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcPIC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcPIC(entity);
  }

  /**
   * Method to retrieve the ExcPIC via an ExcPICPrimaryKey.
   *
   * @param id Long
   * @return ExcPIC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcPIC handle(FindExcPICQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcPICId());
  }

  /**
   * Method to retrieve a collection of all ExcPICs
   *
   * @param query FindAllExcPICQuery
   * @return List<ExcPIC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcPIC> handle(FindAllExcPICQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcPIC, but only if the id matches
   *
   * @param entity ExcPIC
   */
  protected void emitFindExcPIC(ExcPIC entity) {
    LOGGER.info("handling emitFindExcPIC");

    queryUpdateEmitter.emit(
        FindExcPICQuery.class,
        query -> query.getFilter().getExcPICId().equals(entity.getExcPICId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcPIC
   *
   * @param entity ExcPIC
   */
  protected void emitFindAllExcPIC(ExcPIC entity) {
    LOGGER.info("handling emitFindAllExcPIC");

    queryUpdateEmitter.emit(FindAllExcPICQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcPICProjector.class.getName());
}
