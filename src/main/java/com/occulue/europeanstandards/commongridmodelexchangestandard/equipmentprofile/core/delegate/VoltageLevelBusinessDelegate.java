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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * VoltageLevel business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of VoltageLevel related services in the case of a VoltageLevel
 *       business related service failing.
 *   <li>Exposes a simpler, uniform VoltageLevel interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill VoltageLevel business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class VoltageLevelBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public VoltageLevelBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * VoltageLevel Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return VoltageLevelBusinessDelegate
   */
  public static VoltageLevelBusinessDelegate getVoltageLevelInstance() {
    return (new VoltageLevelBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createVoltageLevel(CreateVoltageLevelCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getVoltageLevelId() == null) command.setVoltageLevelId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageLevelValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateVoltageLevelCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateVoltageLevelCommand of VoltageLevel is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create VoltageLevel - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateVoltageLevelCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateVoltageLevel(UpdateVoltageLevelCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      VoltageLevelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateVoltageLevelCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save VoltageLevel - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteVoltageLevelCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteVoltageLevelCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageLevelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteVoltageLevelCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete VoltageLevel using Id = " + command.getVoltageLevelId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the VoltageLevel via VoltageLevelFetchOneSummary
   *
   * @param summary VoltageLevelFetchOneSummary
   * @return VoltageLevelFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public VoltageLevel getVoltageLevel(VoltageLevelFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("VoltageLevelFetchOneSummary arg cannot be null");

    VoltageLevel entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      VoltageLevelValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a VoltageLevel
      // --------------------------------------
      CompletableFuture<VoltageLevel> futureEntity =
          queryGateway.query(
              new FindVoltageLevelQuery(new LoadVoltageLevelFilter(summary.getVoltageLevelId())),
              ResponseTypes.instanceOf(VoltageLevel.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate VoltageLevel with id " + summary.getVoltageLevelId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all VoltageLevels
   *
   * @return List<VoltageLevel>
   * @exception ProcessingException Thrown if any problems
   */
  public List<VoltageLevel> getAllVoltageLevel() throws ProcessingException {
    List<VoltageLevel> list = null;

    try {
      CompletableFuture<List<VoltageLevel>> futureList =
          queryGateway.query(
              new FindAllVoltageLevelQuery(),
              ResponseTypes.multipleInstancesOf(VoltageLevel.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all VoltageLevel";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign HighVoltageLimit on VoltageLevel
   *
   * @param command AssignHighVoltageLimitToVoltageLevelCommand
   * @exception ProcessingException
   */
  public void assignHighVoltageLimit(AssignHighVoltageLimitToVoltageLevelCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVoltageLevelId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    VoltageLevelBusinessDelegate parentDelegate =
        VoltageLevelBusinessDelegate.getVoltageLevelInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VoltageLevelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Voltage using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign HighVoltageLimit on VoltageLevel
   *
   * @param command UnAssignHighVoltageLimitFromVoltageLevelCommand
   * @exception ProcessingException
   */
  public void unAssignHighVoltageLimit(UnAssignHighVoltageLimitFromVoltageLevelCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageLevelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign HighVoltageLimit on VoltageLevel";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign LowVoltageLimit on VoltageLevel
   *
   * @param command AssignLowVoltageLimitToVoltageLevelCommand
   * @exception ProcessingException
   */
  public void assignLowVoltageLimit(AssignLowVoltageLimitToVoltageLevelCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVoltageLevelId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    VoltageLevelBusinessDelegate parentDelegate =
        VoltageLevelBusinessDelegate.getVoltageLevelInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VoltageLevelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Voltage using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign LowVoltageLimit on VoltageLevel
   *
   * @param command UnAssignLowVoltageLimitFromVoltageLevelCommand
   * @exception ProcessingException
   */
  public void unAssignLowVoltageLimit(UnAssignLowVoltageLimitFromVoltageLevelCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageLevelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign LowVoltageLimit on VoltageLevel";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add VoltageLevel to VoltageLevel
   *
   * @param command AssignVoltageLevelToVoltageLevelCommand
   * @exception ProcessingException
   */
  public void addToVoltageLevel(AssignVoltageLevelToVoltageLevelCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getVoltageLevelId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate
            .VoltageLevelBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core
                .delegate.VoltageLevelBusinessDelegate.getVoltageLevelInstance();
    VoltageLevelBusinessDelegate parentDelegate =
        VoltageLevelBusinessDelegate.getVoltageLevelInstance();
    UUID childId = command.getAddTo().getVoltageLevelId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageLevelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a VoltageLevel as VoltageLevel to VoltageLevel";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove VoltageLevel from VoltageLevel
   *
   * @param command RemoveVoltageLevelFromVoltageLevelCommand
   * @exception ProcessingException
   */
  public void removeFromVoltageLevel(RemoveVoltageLevelFromVoltageLevelCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate
            .VoltageLevelBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core
                .delegate.VoltageLevelBusinessDelegate.getVoltageLevelInstance();
    UUID childId = command.getRemoveFrom().getVoltageLevelId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageLevelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add VoltageLevel to VoltageLevels
   *
   * @param command AssignVoltageLevelsToVoltageLevelCommand
   * @exception ProcessingException
   */
  public void addToVoltageLevels(AssignVoltageLevelsToVoltageLevelCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getVoltageLevelId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate
            .VoltageLevelBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core
                .delegate.VoltageLevelBusinessDelegate.getVoltageLevelInstance();
    VoltageLevelBusinessDelegate parentDelegate =
        VoltageLevelBusinessDelegate.getVoltageLevelInstance();
    UUID childId = command.getAddTo().getVoltageLevelId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageLevelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a VoltageLevel as VoltageLevels to VoltageLevel";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove VoltageLevel from VoltageLevels
   *
   * @param command RemoveVoltageLevelsFromVoltageLevelCommand
   * @exception ProcessingException
   */
  public void removeFromVoltageLevels(RemoveVoltageLevelsFromVoltageLevelCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate
            .VoltageLevelBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core
                .delegate.VoltageLevelBusinessDelegate.getVoltageLevelInstance();
    UUID childId = command.getRemoveFrom().getVoltageLevelId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageLevelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return VoltageLevel
   */
  private VoltageLevel load(UUID id) throws ProcessingException {
    voltageLevel =
        VoltageLevelBusinessDelegate.getVoltageLevelInstance()
            .getVoltageLevel(new VoltageLevelFetchOneSummary(id));
    return voltageLevel;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private VoltageLevel voltageLevel = null;
  private static final Logger LOGGER =
      Logger.getLogger(VoltageLevelBusinessDelegate.class.getName());
}
