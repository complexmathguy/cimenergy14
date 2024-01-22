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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.validator.*;
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
 * GeographicalLocationVersion business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of GeographicalLocationVersion related services in the case of a
 *       GeographicalLocationVersion business related service failing.
 *   <li>Exposes a simpler, uniform GeographicalLocationVersion interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       GeographicalLocationVersion business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class GeographicalLocationVersionBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public GeographicalLocationVersionBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * GeographicalLocationVersion Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return GeographicalLocationVersionBusinessDelegate
   */
  public static GeographicalLocationVersionBusinessDelegate
      getGeographicalLocationVersionInstance() {
    return (new GeographicalLocationVersionBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createGeographicalLocationVersion(
      CreateGeographicalLocationVersionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getGeographicalLocationVersionId() == null)
        command.setGeographicalLocationVersionId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateGeographicalLocationVersionCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateGeographicalLocationVersionCommand of GeographicalLocationVersion is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create GeographicalLocationVersion - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateGeographicalLocationVersionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateGeographicalLocationVersion(
      UpdateGeographicalLocationVersionCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateGeographicalLocationVersionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save GeographicalLocationVersion - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteGeographicalLocationVersionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteGeographicalLocationVersionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteGeographicalLocationVersionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete GeographicalLocationVersion using Id = "
              + command.getGeographicalLocationVersionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the GeographicalLocationVersion via
   * GeographicalLocationVersionFetchOneSummary
   *
   * @param summary GeographicalLocationVersionFetchOneSummary
   * @return GeographicalLocationVersionFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public GeographicalLocationVersion getGeographicalLocationVersion(
      GeographicalLocationVersionFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "GeographicalLocationVersionFetchOneSummary arg cannot be null");

    GeographicalLocationVersion entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a GeographicalLocationVersion
      // --------------------------------------
      CompletableFuture<GeographicalLocationVersion> futureEntity =
          queryGateway.query(
              new FindGeographicalLocationVersionQuery(
                  new LoadGeographicalLocationVersionFilter(
                      summary.getGeographicalLocationVersionId())),
              ResponseTypes.instanceOf(GeographicalLocationVersion.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate GeographicalLocationVersion with id "
              + summary.getGeographicalLocationVersionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all GeographicalLocationVersions
   *
   * @return List<GeographicalLocationVersion>
   * @exception ProcessingException Thrown if any problems
   */
  public List<GeographicalLocationVersion> getAllGeographicalLocationVersion()
      throws ProcessingException {
    List<GeographicalLocationVersion> list = null;

    try {
      CompletableFuture<List<GeographicalLocationVersion>> futureList =
          queryGateway.query(
              new FindAllGeographicalLocationVersionQuery(),
              ResponseTypes.multipleInstancesOf(GeographicalLocationVersion.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all GeographicalLocationVersion";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign BaseUML on GeographicalLocationVersion
   *
   * @param command AssignBaseUMLToGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void assignBaseUML(AssignBaseUMLToGeographicalLocationVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeographicalLocationVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    GeographicalLocationVersionBusinessDelegate parentDelegate =
        GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign BaseUML on GeographicalLocationVersion
   *
   * @param command UnAssignBaseUMLFromGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void unAssignBaseUML(UnAssignBaseUMLFromGeographicalLocationVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BaseUML on GeographicalLocationVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign BaseURI on GeographicalLocationVersion
   *
   * @param command AssignBaseURIToGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void assignBaseURI(AssignBaseURIToGeographicalLocationVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeographicalLocationVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    GeographicalLocationVersionBusinessDelegate parentDelegate =
        GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign BaseURI on GeographicalLocationVersion
   *
   * @param command UnAssignBaseURIFromGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void unAssignBaseURI(UnAssignBaseURIFromGeographicalLocationVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BaseURI on GeographicalLocationVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Date on GeographicalLocationVersion
   *
   * @param command AssignDateToGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void assignDate(AssignDateToGeographicalLocationVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeographicalLocationVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .DateProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .DateProxyBusinessDelegate.getDateProxyInstance();
    GeographicalLocationVersionBusinessDelegate parentDelegate =
        GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance();
    UUID childId = command.getAssignment().getDateProxyId();
    DateProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get DateProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Date on GeographicalLocationVersion
   *
   * @param command UnAssignDateFromGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void unAssignDate(UnAssignDateFromGeographicalLocationVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Date on GeographicalLocationVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign DifferenceModelURI on GeographicalLocationVersion
   *
   * @param command AssignDifferenceModelURIToGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void assignDifferenceModelURI(
      AssignDifferenceModelURIToGeographicalLocationVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeographicalLocationVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    GeographicalLocationVersionBusinessDelegate parentDelegate =
        GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign DifferenceModelURI on GeographicalLocationVersion
   *
   * @param command UnAssignDifferenceModelURIFromGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void unAssignDifferenceModelURI(
      UnAssignDifferenceModelURIFromGeographicalLocationVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign DifferenceModelURI on GeographicalLocationVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EntsoeUML on GeographicalLocationVersion
   *
   * @param command AssignEntsoeUMLToGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void assignEntsoeUML(AssignEntsoeUMLToGeographicalLocationVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeographicalLocationVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    GeographicalLocationVersionBusinessDelegate parentDelegate =
        GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign EntsoeUML on GeographicalLocationVersion
   *
   * @param command UnAssignEntsoeUMLFromGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void unAssignEntsoeUML(UnAssignEntsoeUMLFromGeographicalLocationVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EntsoeUML on GeographicalLocationVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EntsoeURI on GeographicalLocationVersion
   *
   * @param command AssignEntsoeURIToGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void assignEntsoeURI(AssignEntsoeURIToGeographicalLocationVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeographicalLocationVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    GeographicalLocationVersionBusinessDelegate parentDelegate =
        GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign EntsoeURI on GeographicalLocationVersion
   *
   * @param command UnAssignEntsoeURIFromGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void unAssignEntsoeURI(UnAssignEntsoeURIFromGeographicalLocationVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EntsoeURI on GeographicalLocationVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ModelDescriptionURI on GeographicalLocationVersion
   *
   * @param command AssignModelDescriptionURIToGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void assignModelDescriptionURI(
      AssignModelDescriptionURIToGeographicalLocationVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeographicalLocationVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    GeographicalLocationVersionBusinessDelegate parentDelegate =
        GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ModelDescriptionURI on GeographicalLocationVersion
   *
   * @param command UnAssignModelDescriptionURIFromGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void unAssignModelDescriptionURI(
      UnAssignModelDescriptionURIFromGeographicalLocationVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ModelDescriptionURI on GeographicalLocationVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NamespaceRDF on GeographicalLocationVersion
   *
   * @param command AssignNamespaceRDFToGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void assignNamespaceRDF(AssignNamespaceRDFToGeographicalLocationVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeographicalLocationVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    GeographicalLocationVersionBusinessDelegate parentDelegate =
        GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NamespaceRDF on GeographicalLocationVersion
   *
   * @param command UnAssignNamespaceRDFFromGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void unAssignNamespaceRDF(
      UnAssignNamespaceRDFFromGeographicalLocationVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NamespaceRDF on GeographicalLocationVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NamespaceUML on GeographicalLocationVersion
   *
   * @param command AssignNamespaceUMLToGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void assignNamespaceUML(AssignNamespaceUMLToGeographicalLocationVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeographicalLocationVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    GeographicalLocationVersionBusinessDelegate parentDelegate =
        GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NamespaceUML on GeographicalLocationVersion
   *
   * @param command UnAssignNamespaceUMLFromGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void unAssignNamespaceUML(
      UnAssignNamespaceUMLFromGeographicalLocationVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NamespaceUML on GeographicalLocationVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ShortName on GeographicalLocationVersion
   *
   * @param command AssignShortNameToGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void assignShortName(AssignShortNameToGeographicalLocationVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getGeographicalLocationVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    GeographicalLocationVersionBusinessDelegate parentDelegate =
        GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ShortName on GeographicalLocationVersion
   *
   * @param command UnAssignShortNameFromGeographicalLocationVersionCommand
   * @exception ProcessingException
   */
  public void unAssignShortName(UnAssignShortNameFromGeographicalLocationVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GeographicalLocationVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ShortName on GeographicalLocationVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return GeographicalLocationVersion
   */
  private GeographicalLocationVersion load(UUID id) throws ProcessingException {
    geographicalLocationVersion =
        GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
            .getGeographicalLocationVersion(new GeographicalLocationVersionFetchOneSummary(id));
    return geographicalLocationVersion;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private GeographicalLocationVersion geographicalLocationVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(GeographicalLocationVersionBusinessDelegate.class.getName());
}
