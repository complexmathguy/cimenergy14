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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GovSteamCC as outlined for the CQRS pattern. All event handling and query handling
 * related to GovSteamCC are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovSteamCCAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govSteamCC")
@Component("govSteamCC-projector")
public class GovSteamCCProjector extends GovSteamCCEntityProjector {

  // core constructor
  public GovSteamCCProjector(
      GovSteamCCRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovSteamCCEvent
   */
  @EventHandler(payloadType = CreateGovSteamCCEvent.class)
  public void handle(CreateGovSteamCCEvent event) {
    LOGGER.info("handling CreateGovSteamCCEvent - " + event);
    GovSteamCC entity = new GovSteamCC();
    entity.setGovSteamCCId(event.getGovSteamCCId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UpdateGovSteamCCEvent
   */
  @EventHandler(payloadType = UpdateGovSteamCCEvent.class)
  public void handle(UpdateGovSteamCCEvent event) {
    LOGGER.info("handling UpdateGovSteamCCEvent - " + event);

    GovSteamCC entity = new GovSteamCC();
    entity.setGovSteamCCId(event.getGovSteamCCId());
    entity.setDhp(event.getDhp());
    entity.setDlp(event.getDlp());
    entity.setFhp(event.getFhp());
    entity.setFlp(event.getFlp());
    entity.setMwbase(event.getMwbase());
    entity.setPmaxhp(event.getPmaxhp());
    entity.setPmaxlp(event.getPmaxlp());
    entity.setRhp(event.getRhp());
    entity.setRlp(event.getRlp());
    entity.setT1hp(event.getT1hp());
    entity.setT1lp(event.getT1lp());
    entity.setT3hp(event.getT3hp());
    entity.setT3lp(event.getT3lp());
    entity.setT4hp(event.getT4hp());
    entity.setT4lp(event.getT4lp());
    entity.setT5hp(event.getT5hp());
    entity.setT5lp(event.getT5lp());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event DeleteGovSteamCCEvent
   */
  @EventHandler(payloadType = DeleteGovSteamCCEvent.class)
  public void handle(DeleteGovSteamCCEvent event) {
    LOGGER.info("handling DeleteGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovSteamCC entity = delete(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignDhpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignDhpToGovSteamCCEvent.class)
  public void handle(AssignDhpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignDhpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignDhp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignDhpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignDhpFromGovSteamCCEvent.class)
  public void handle(UnAssignDhpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignDhpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignDhp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignDlpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignDlpToGovSteamCCEvent.class)
  public void handle(AssignDlpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignDlpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignDlp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignDlpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignDlpFromGovSteamCCEvent.class)
  public void handle(UnAssignDlpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignDlpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignDlp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignFhpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignFhpToGovSteamCCEvent.class)
  public void handle(AssignFhpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignFhpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignFhp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignFhpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignFhpFromGovSteamCCEvent.class)
  public void handle(UnAssignFhpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignFhpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignFhp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignFlpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignFlpToGovSteamCCEvent.class)
  public void handle(AssignFlpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignFlpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignFlp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignFlpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignFlpFromGovSteamCCEvent.class)
  public void handle(UnAssignFlpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignFlpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignFlp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignMwbaseToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignMwbaseToGovSteamCCEvent.class)
  public void handle(AssignMwbaseToGovSteamCCEvent event) {
    LOGGER.info("handling AssignMwbaseToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignMwbase(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovSteamCCEvent.class)
  public void handle(UnAssignMwbaseFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignMwbaseFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignMwbase(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignPmaxhpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignPmaxhpToGovSteamCCEvent.class)
  public void handle(AssignPmaxhpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignPmaxhpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignPmaxhp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignPmaxhpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignPmaxhpFromGovSteamCCEvent.class)
  public void handle(UnAssignPmaxhpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignPmaxhpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignPmaxhp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignPmaxlpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignPmaxlpToGovSteamCCEvent.class)
  public void handle(AssignPmaxlpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignPmaxlpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignPmaxlp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignPmaxlpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignPmaxlpFromGovSteamCCEvent.class)
  public void handle(UnAssignPmaxlpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignPmaxlpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignPmaxlp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignRhpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignRhpToGovSteamCCEvent.class)
  public void handle(AssignRhpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignRhpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignRhp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignRhpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignRhpFromGovSteamCCEvent.class)
  public void handle(UnAssignRhpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignRhpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignRhp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignRlpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignRlpToGovSteamCCEvent.class)
  public void handle(AssignRlpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignRlpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignRlp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignRlpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignRlpFromGovSteamCCEvent.class)
  public void handle(UnAssignRlpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignRlpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignRlp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignT1hpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignT1hpToGovSteamCCEvent.class)
  public void handle(AssignT1hpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignT1hpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignT1hp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignT1hpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignT1hpFromGovSteamCCEvent.class)
  public void handle(UnAssignT1hpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignT1hpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignT1hp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignT1lpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignT1lpToGovSteamCCEvent.class)
  public void handle(AssignT1lpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignT1lpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignT1lp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignT1lpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignT1lpFromGovSteamCCEvent.class)
  public void handle(UnAssignT1lpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignT1lpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignT1lp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignT3hpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignT3hpToGovSteamCCEvent.class)
  public void handle(AssignT3hpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignT3hpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignT3hp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignT3hpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignT3hpFromGovSteamCCEvent.class)
  public void handle(UnAssignT3hpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignT3hpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignT3hp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignT3lpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignT3lpToGovSteamCCEvent.class)
  public void handle(AssignT3lpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignT3lpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignT3lp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignT3lpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignT3lpFromGovSteamCCEvent.class)
  public void handle(UnAssignT3lpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignT3lpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignT3lp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignT4hpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignT4hpToGovSteamCCEvent.class)
  public void handle(AssignT4hpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignT4hpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignT4hp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignT4hpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignT4hpFromGovSteamCCEvent.class)
  public void handle(UnAssignT4hpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignT4hpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignT4hp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignT4lpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignT4lpToGovSteamCCEvent.class)
  public void handle(AssignT4lpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignT4lpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignT4lp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignT4lpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignT4lpFromGovSteamCCEvent.class)
  public void handle(UnAssignT4lpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignT4lpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignT4lp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignT5hpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignT5hpToGovSteamCCEvent.class)
  public void handle(AssignT5hpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignT5hpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignT5hp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignT5hpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignT5hpFromGovSteamCCEvent.class)
  public void handle(UnAssignT5hpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignT5hpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignT5hp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event AssignT5lpToGovSteamCCEvent
   */
  @EventHandler(payloadType = AssignT5lpToGovSteamCCEvent.class)
  public void handle(AssignT5lpToGovSteamCCEvent event) {
    LOGGER.info("handling AssignT5lpToGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamCC entity = assignT5lp(event.getGovSteamCCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /*
   * @param	event UnAssignT5lpFromGovSteamCCEvent
   */
  @EventHandler(payloadType = UnAssignT5lpFromGovSteamCCEvent.class)
  public void handle(UnAssignT5lpFromGovSteamCCEvent event) {
    LOGGER.info("handling UnAssignT5lpFromGovSteamCCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamCC entity = unAssignT5lp(event.getGovSteamCCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamCC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamCC(entity);
  }

  /**
   * Method to retrieve the GovSteamCC via an GovSteamCCPrimaryKey.
   *
   * @param id Long
   * @return GovSteamCC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovSteamCC handle(FindGovSteamCCQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovSteamCCId());
  }

  /**
   * Method to retrieve a collection of all GovSteamCCs
   *
   * @param query FindAllGovSteamCCQuery
   * @return List<GovSteamCC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovSteamCC> handle(FindAllGovSteamCCQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovSteamCC, but only if the id matches
   *
   * @param entity GovSteamCC
   */
  protected void emitFindGovSteamCC(GovSteamCC entity) {
    LOGGER.info("handling emitFindGovSteamCC");

    queryUpdateEmitter.emit(
        FindGovSteamCCQuery.class,
        query -> query.getFilter().getGovSteamCCId().equals(entity.getGovSteamCCId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovSteamCC
   *
   * @param entity GovSteamCC
   */
  protected void emitFindAllGovSteamCC(GovSteamCC entity) {
    LOGGER.info("handling emitFindAllGovSteamCC");

    queryUpdateEmitter.emit(FindAllGovSteamCCQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovSteamCCProjector.class.getName());
}
